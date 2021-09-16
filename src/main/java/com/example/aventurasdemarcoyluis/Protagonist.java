package com.example.aventurasdemarcoyluis;

/**
 * The type Protagonist. Abstract class meant for players: Luigi and Marcos. Incorporates
 * an additional variable in comparison with the abstract type Character: fp, which restrict
 * the use of items.
 */
public abstract class Protagonist extends AbstractCharacter implements Player {
    private int fp;

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
    }

    /**
     * Picks up an item, calling the item's method effect() and
     * @param anItem the item that is picked up.
     */
    public void pickItem(Item anItem) {
        anItem.effect(this);
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
}
