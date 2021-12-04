package com.example.aventurasdemarcoyluis.model.Items;

import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;

/**
 * The type Star.
 */
public class Star extends AbstractItem {
    /**
     * Instantiates a new Star Item
     */
    public Star() {
        super("Star");
    }

    @Override
    public void effect(Player aPlayer) {
        /** Set's the character's state to invincible.
         *
         *
         * @param aPlayer the level
         */
        aPlayer.invincible();
    }
}
