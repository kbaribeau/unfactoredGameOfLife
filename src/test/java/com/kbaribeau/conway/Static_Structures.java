package com.kbaribeau.conway;

import org.junit.Test;

import static com.kbaribeau.conway.testsupport.CustomMatchers.evolvesTo;
import static org.junit.Assert.assertThat;


//This is a port of tests written by @coreyhaines
//available here:
//http://github.com/coreyhaines/practice_game_of_life/blob/master/features/static_structures.feature
public class Static_Structures {

	@Test
	public void block() {
		String start =
			".....\n" +
			".XX..\n" +
			".XX..\n" +
			".....\n" +
			".....";
		String end =
			".....\n" +
			".XX..\n" +
			".XX..\n" +
			".....\n" +
			".....";

		assertThat(new Game(start), evolvesTo(end));
	}

	@Test
	public void beehive() {
		String start =
			".....\n" +
			"..XX.\n" +
			".X..X\n" +
			"..XX.\n" +
			".....";

		String end =
			".....\n" +
			"..XX.\n" +
			".X..X\n" +
			"..XX.\n" +
			".....";

		assertThat(new Game(start), evolvesTo(end));
	}

	@Test
	public void loaf() {
		String start =
			".....\n" +
			"..XX.\n" +
			".X..X\n" +
			"..X.X\n" +
			"...X.\n" +
			".....";

		String end =
			".....\n" +
			"..XX.\n" +
			".X..X\n" +
			"..X.X\n" +
			"...X.\n" +
			".....";

		assertThat(new Game(start), evolvesTo(end));
	}

	@Test	
	public void boat() {
		String start =
			".....\n" +
			".XX..\n" +
			".X.X.\n" +
			"..X..\n" +
			".....";

		String end =
			".....\n" +
			".XX..\n" +
			".X.X.\n" +
			"..X..\n" +
			".....";
		
		assertThat(new Game(start), evolvesTo(end));
	}

}
