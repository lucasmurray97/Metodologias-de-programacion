package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractItem;
import com.example.aventurasdemarcoyluis.interfaces.Player;

/**
 * The type Honey syrup. It's an item with the effect of increases a protagonist's fp by 3.
 */
public class HoneySyrup extends AbstractItem {
    /**
     * Instantiates a new HoneySyrup Item
     */
    public HoneySyrup() {
        super("HoneySyrup");
    }

    @Override
    /**
     * Implements the effect of picking up a Honey Syrup.
     */
    public void effect(Player aPlayer) {
        int newFp = aPlayer.getFp() + 3;
        aPlayer.setFp(newFp);
    }
}
