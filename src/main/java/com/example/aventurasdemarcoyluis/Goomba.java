package com.example.aventurasdemarcoyluis;

/**
 * The type Goomba. It's an enemy character.
 */
public class Goomba extends AbstractCharacter implements Enemy, Character {
    /**
     * Instantiates a new Goomba. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Goomba(int lvl) {
        super(lvl, "Goomba", 100, 100, 100);
    }

}
