package com.example.aventurasdemarcoyluis;

/**
 * The interface Item. It forces each Item to implement it's own effect.
 */
public interface Item {

    /**
     * Effect. Implementation of the item's effect over a protagonist character. Restricts it's
     * picking only to protagonists.
     *
     * @param protagonist the protagonist that picked up the item.
     */
    void effect(Protagonist protagonist);
}
