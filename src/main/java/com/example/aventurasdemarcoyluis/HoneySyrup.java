package com.example.aventurasdemarcoyluis;

/**
 * The type Honey syrup. It's an item with the effect of increases a protagonist's fp by 3.
 */
public class HoneySyrup implements Item{
    @Override
    /**
     * Implements the effect of picking up a Honey Syrup.
     */
    public void effect(Protagonist protagonist) {
        int newFp = protagonist.getFp() + 3;
        protagonist.setFp(newFp);
    }
}
