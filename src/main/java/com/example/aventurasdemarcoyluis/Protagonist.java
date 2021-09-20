package com.example.aventurasdemarcoyluis;

import java.util.HashMap;

/**
 * The type Protagonist. Abstract class meant for players: Luigi and Marcos. Incorporates
 * an additional variable in comparison with the abstract type Character: fp, which restrict
 * the use of items.
 */
public abstract class Protagonist extends AbstractCharacter implements Player, Character {
    private int fp;
    private BagPack bag;

    /**
     * Instantiates a new Protagonist, setting it's fp to 0.
     *
     * @param lvl     the level
     * @param type    the type
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     */
    public Protagonist(int lvl, String type, int baseHp, int baseAtk, int baseDef) {
        super(lvl, type, baseHp, baseAtk, baseDef);
        this.fp = 0;
        this.bag = new BagPack(this);
    }

    /**
     * Picks up an item, calling the item's method effect() and
     * @param anItem the item that is picked up.
     */
    public void pickItem(Item anItem) {
        bag.pickItem(anItem);

    }

    public void useItem(String anItem){
        bag.useItem(anItem);
    }
    /**
     * Gets fp.
     *
     * @return the fp
     */
    public int getFp() {
        return fp;
    }

    /**
     * Sets fp.
     *
     * @param fp the fp
     */
    public void setFp(int fp) {
        this.fp = fp;
    }

    /**
     * Method to be implemented in future versions.
     */
    public void invincible() {
    }
    public int getQuantity(String anItem){
        return bag.getQuantity(anItem);
    }

}
