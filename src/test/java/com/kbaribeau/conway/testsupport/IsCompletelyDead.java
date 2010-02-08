package com.kbaribeau.conway.testsupport;

import com.kbaribeau.conway.Game;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class IsCompletelyDead extends BaseMatcher<Game> {
    
    @Override
    public boolean matches(Object o) {
        Game g = (Game) o;
        return g.toString().indexOf("X") == -1;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("completely dead grid");    
    }
}
