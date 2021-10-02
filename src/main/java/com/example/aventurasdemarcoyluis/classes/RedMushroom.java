package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractItem;
import com.example.aventurasdemarcoyluis.interfaces.Player;

/**
 * The type Red mushroom.
 */
public class RedMushroom extends AbstractItem {
    /**
     * Instantiates a new RedMushroom.
     */
    public RedMushroom() {
        super("RedMushroom");
    }

    /**
     * Increments Hp by 10%
     * @param aPlayer the player that uses the item.
     */
    @Override
    public void effect(Player aPlayer) {
        int newHp = (int) (1.1*aPlayer.getHp());
        aPlayer.setHp(newHp);
    }
}
