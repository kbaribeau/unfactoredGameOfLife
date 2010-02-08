package com.kbaribeau.conway;

import org.junit.Test;

import static com.kbaribeau.conway.testsupport.CustomMatchers.isCompletelyDead;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LifeTest {

	@Test
	public void parse_ShouldParseEmptyGrid() {
		String grid =
			"...\n" +
			"...\n" +
			"...";
		Game game = new Game(grid);

		assertThat(game, isCompletelyDead());
	}

	@Test
	public void parse_ShouldParseGridWithOneCell() {
		String grid =
			"X..\n" +
			"...\n" +
			"...";
		Game game = new Game(grid);

		assertThat(game.isAlive(0, 0), is(true));
	}

	@Test
	public void parse_ShouldParseGridCorners() {
		String grid =
			"X.X\n" +
			"...\n" +
			"X.X";
		Game game = new Game(grid);

		assertThat(game.isAlive(0, 0), is(false));
		assertThat(game.isAlive(0, 2), is(true));
		assertThat(game.isAlive(2, 0), is(true));
		assertThat(game.isAlive(2, 2), is(true));
	}

	@Test
	public void toString_ShouldPrintEmptyGrid() {
		String grid =
			"...\n" +
			"...\n" +
			"...";
		Game game = new Game(grid);

		assertThat(game.toString(), equalTo(grid));
	}

	@Test
	public void toString_ShouldPrintGridWithOneCell() {
		String grid =
			"X..\n" +
			"...\n" +
			"...";
		Game game = new Game(grid);

		assertThat(game.toString(), equalTo(grid));
	}

	@Test
	public void toString_ShouldPrintGridCorners() {
		String grid =
			"X.X\n" +
			"...\n" +
			"X.X";
		Game game = new Game(grid);

		assertThat(game.toString(), equalTo(grid));
	}


	@Test
	public void deadGrid_ShouldStayDead() {
		String start =
			"...\n" +
			"...\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game, isCompletelyDead());
	}

	@Test
	public void ruleOne_CellsWithZeroNeighborsShouldDie() {
		String start =
			"X..\n" +
			"...\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game, isCompletelyDead());
	}

	@Test
	public void ruleOne_CellsWithOneNeighborShouldDie() {
		String start =
			"X..\n" +
			"X..\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game, isCompletelyDead());

	}


	@Test
	public void ruleTwo_CellsWithFourNeighborsShouldDie() {
		String start =
			"XXX\n" +
			"XX.\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(1, 1), is(false));
	}

	@Test
	public void ruleTwo_CellsWithFiveNeighborsShouldDie() {
		String start =
			"XXX\n" +
			"XXX\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(1, 1), is(false));
	}

	@Test
	public void ruleTwo_CellsWithEightNeighborsShouldDie() {
		String start =
			"XXX\n" +
			"XXX\n" +
			"XXX";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(1, 1), is(false));
	}

	@Test
	public void ruleThree_CellsWithTwoNeighborsShouldLiveOn() {
		String start =
			"X..\n" +
			"XX.\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(1, 1), is(true));
	}

	@Test
	public void ruleThree_CellsWithThreeNeighborsShouldLiveOn() {
		String start =
			"X..\n" +
			"XX.\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(1, 1), is(true));
	}

	@Test
	public void ruleFour_DeadCellsWithThreeNeighborsShouldSpawnLife() {
		String start =
			"...\n" +
			"XXX\n" +
			"...";
		Game game = new Game(start);

		game.tick();

		assertThat(game.isAlive(0, 1), is(true));
	}
}

