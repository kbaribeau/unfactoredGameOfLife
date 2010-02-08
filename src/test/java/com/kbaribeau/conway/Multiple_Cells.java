package com.kbaribeau.conway;

import org.junit.Test;

import static com.kbaribeau.conway.testsupport.CustomMatchers.evolvesTo;
import static org.junit.Assert.assertThat;


//This is a port of tests written by @coreyhaines
//available here:
//http://github.com/coreyhaines/practice_game_of_life/blob/master/features/multiple_cells.feature
public class Multiple_Cells {
	
	@Test
	public void SparseGridWithNobodyStayingAlive() {
		String start =
			".....\n" +
			".X.X.\n" +
			".....\n" +
			".X.X.\n" +
			".....";

		String end =
			".....\n" +
			".....\n" +
			".....\n" +
			".....\n" +
			".....";

		assertThat(new Game(start), evolvesTo(end));
	}

	@Test
	public void OvercrowdedGrid() {
		String start =
			".....\n" +
			".XXX.\n" +
			".XXX.\n" +
			".XXX.\n" +
			".....";

		String end =
			"..X..\n" +
			".X.X.\n" +
			"X...X\n" +
			".X.X.\n" +
			"..X..";

		assertThat(new Game(start), evolvesTo(end));
	}

	@Test
	public void multipleDeadCellsComingToLife() {
		String start =
			".....\n" +
			".....\n" +
			".XXX.\n" +
			".....\n" +
			".....";

		String end =
			".....\n" +
			"..X..\n" +
			"..X..\n" +
			"..X..\n" +
			".....";

		assertThat(new Game(start), evolvesTo(end));
	}

}
