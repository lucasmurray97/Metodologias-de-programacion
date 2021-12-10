package com.example.aventurasdemarcoyluis.model.Characters.Players;

import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Items.Item;

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

    /**
     * Gets def.
     *
     * @return the def
     */
    int getDef();

    /**
     * Normal attacked.
     *
     * @param damage  the damage
     * @param anEnemy the an enemy
     */
    void normalAttacked(int damage, Enemy anEnemy);


    /**
     * Use item.
     *
     * @param anItem the an item
     */
    void useItem(String anItem);
}
