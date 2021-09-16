package com.example.aventurasdemarcoyluis;

/**
 * The type Spiny. It's an enemy character.
 */
public class Spiny extends AbstractCharacter implements Enemy  {
    /**
     * Instantiates a new Spiny. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level.
     */
    public Spiny(int lvl) {
        super(lvl, "Spiny", 100, 100, 100);
    }
}
