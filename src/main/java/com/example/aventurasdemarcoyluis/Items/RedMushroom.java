package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Characters.Players.Player;

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
        int newHp = (int) (0.1*aPlayer.getMaxAtk());
        aPlayer.setHp(aPlayer.getHp()+newHp);
    }
}
