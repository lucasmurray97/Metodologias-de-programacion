package com.example.aventurasdemarcoyluis.interfaces;

/**
 * The interface Player. Implemented by Luigi and Marcos, forces the implementation of pickItem
 * method.
 */
public interface Player extends Character {
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

    /**
     * Sets fp.
     *
     * @param newFp the new fp
     */
    void setFp(int newFp);

    /**
     * Gets fp.
     *
     * @return the fp
     */
    int getFp();

    /**
     * Gets hp.
     *
     * @return the hp
     */
    int getHp();

    /**
     * Sets hp.
     *
     * @param newHp the new hp
     */
    void setHp(int newHp);

    /**
     * Invincible.
     */
    void invincible();

    int getDef();

    void normalAttacked(int damage, Enemy anEnemy);
}
