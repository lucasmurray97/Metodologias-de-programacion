package com.example.aventurasdemarcoyluis;

/**
 * The interface Player. Implemented by Luigi and Marcos, forces the implementation of pickItem
 * method.
 */
public interface Player {
    /**
     * Pick item.
     *
     * @param anItem the item that is picked up.
     */
    public void pickItem(Item anItem);

    /**
     * Gets type.
     *
     * @return the type
     */
    String getType();
}
