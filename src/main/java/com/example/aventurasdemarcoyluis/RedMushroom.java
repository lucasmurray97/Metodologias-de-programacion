package com.example.aventurasdemarcoyluis;

/**
 * The type Red mushroom.
 */
public class RedMushroom implements Item{
    /**
     * Instantiates a new Boo.
     *
     * @param protagonist the lvl
     */
    @Override
    public void effect(Protagonist protagonist) {
        int newHp = (int) (1.1*protagonist.getHp());
        protagonist.setHp(newHp);
    }
}
