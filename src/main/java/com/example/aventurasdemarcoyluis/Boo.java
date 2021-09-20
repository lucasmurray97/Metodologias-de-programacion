package com.example.aventurasdemarcoyluis;

/**
 * The type Boo. It's an enemy character.
 */
public class Boo extends AbstractCharacter implements Enemy, Character {
    /**
     * Instantiates a new Boo. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level
     */
    public Boo(int lvl) {
        super(lvl, "Boo", 100, 100, 100);
    }

}
