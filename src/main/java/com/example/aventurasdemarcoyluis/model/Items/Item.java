package com.example.aventurasdemarcoyluis.model.Items;

import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;

/**
 * The interface Item. It forces each Item to implement it's own effect.
 */
public interface Item {

    /**
     * Effect. Implementation of the item's effect over a protagonist character. Restricts it's
     * picking only to protagonists.
     *
     * @param player the player that picked up the item.
     */
    void effect(Player player);

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();
}
