package com.example.aventurasdemarcoyluis;

/**
 * The type Luigi. It's a protagonist character, intended to be used by the user.
 */
public class Luigi extends Protagonist implements Player, Character {
    /**
     * Instantiates a new Luigi. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level.
     */
    public Luigi(int lvl) {
        super(lvl, "Luigi", 100, 100, 100);
    }

}
