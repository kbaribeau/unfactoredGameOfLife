package com.kbaribeau.conway;

import com.kbaribeau.conway.Game;
import com.kbaribeau.conway.IsCompletelyDead;
import org.hamcrest.Matcher;

public class CustomMatchers {
    public static Matcher<Game> isCompletelyDead() {
        return new IsCompletelyDead();
    }
}
