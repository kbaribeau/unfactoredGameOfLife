package com.kbaribeau.conway.testsupport;

import com.kbaribeau.conway.Game;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class EvolvesTo extends BaseMatcher<Game> {
	private String endState;

	public EvolvesTo(String endState) {
		this.endState = endState;
	}

	@Override
	public boolean matches(Object o) {
		Game g = (Game) o;
		g.tick();
		return g.toString().equals(endState);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(endState);
	}
}
