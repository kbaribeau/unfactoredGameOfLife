package com.kbaribeau.conway;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class IsCompletelyDead extends BaseMatcher<Game> {
    
    @Override
    public boolean matches(Object o) {
        Game g = (Game) o;
        for (int x = 0; x < g.grid.length; x++) {
            for (int y = 0; y < g.grid[x].length; y++) {
                if (g.grid[x][y]) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("completely dead grid");    
    }
}
