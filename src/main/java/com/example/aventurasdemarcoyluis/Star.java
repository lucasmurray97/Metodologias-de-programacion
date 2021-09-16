package com.example.aventurasdemarcoyluis;

/**
 * The type Star.
 */
public class Star implements Item{
    @Override
    public void effect(Protagonist protagonist) {
        /** Set's the character's state to invincible.
         *
         *
         * @param protagonist the level
         */
        protagonist.invincible();
    }
}
