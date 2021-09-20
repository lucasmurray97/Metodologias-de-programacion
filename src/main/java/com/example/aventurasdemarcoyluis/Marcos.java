package com.example.aventurasdemarcoyluis;

/**
 * The type Marcos. It's a protagonist character, intended to be used by the user.
 */
public class Marcos extends Protagonist implements Player, Character {
    /**
     * Instantiates a new Marcos. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Marcos(int lvl) {
        super(lvl, "Marcos", 100, 100, 100);
    }
}
