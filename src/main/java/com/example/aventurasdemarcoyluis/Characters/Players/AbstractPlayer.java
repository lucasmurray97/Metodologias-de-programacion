package com.example.aventurasdemarcoyluis.Characters.Players;

import com.example.aventurasdemarcoyluis.Characters.AbstractCharacter;
import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Items.Item;

import java.util.Random;

/**
 * The type Protagonist. Abstract class meant for players: Luigi and Marcos. Incorporates
 * an additional variable in comparison with the abstract type Character: fp, which restrict
 * the use of items.
 */
public abstract class AbstractPlayer extends AbstractCharacter implements Player {
    private int fp;
    private BagPack bag;
    private Random random;

    /**
     * Instantiates a new Protagonist, setting it's fp to 0. An empty bag is instantiated with him.
     *
     * @param lvl     the level
     * @param type    the type
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     */
    public AbstractPlayer(int lvl, String type, int baseHp, int baseAtk, int baseDef) {
        super(lvl, type, baseHp, baseAtk, baseDef);
        this.fp = 0;
        this.random = new Random();
    }

    /**
     * Instantiates a new Abstract player, linking him with the common bagpack
     *
     * @param lvl     the lvl
     * @param type    the type
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     * @param bag     the bag that is shared between players.
     */
    public AbstractPlayer(int lvl, String type, int baseHp, int baseAtk, int baseDef, BagPack bag) {
        super(lvl, type, baseHp, baseAtk, baseDef);
        this.fp = 0;
        this.bag = bag;
        this.random = new Random();
    }

    /**
     * Picks up an item and stores it in the bagpack.
     * @param anItem the item that is picked up.
     */
    public void pickItem(Item anItem) {
        bag.addItem(anItem);

    }

    /**
     * Uses item an item.
     *
     * @param anItem item being used.
     */

    /**
     * Gets fp.
     *
     * @return the fp
     */
    public void useItem(String anItem){
        bag.useItem(anItem, this);
    }
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

    /**
     * Get's the quantity of item anItem present in the character's bagpack.
     *
     * @param anItem the an item
     * @return the int
     */
    public int getQuantity(String anItem){
        return bag.getQuantity(anItem);
    }

    /**
     * Gets the character's bagpack.
     *
     * @return the bag pack
     */
    public BagPack getBag(){
        return bag;
    }

    public void setBag(BagPack aBagpack){
        this.bag = aBagpack;
    }
    /**
     * Jump attack.
     *
     * @param anEnemy the an enemy
     */
    protected void jumpAttack(Enemy anEnemy){
        this.getState().jumpAttack();
        int damage = (int) Math.round(this.getAtk() * (this.getLvl() / (double) anEnemy.getDef()));
        anEnemy.jumpAttacked(damage, this);
        this.setFp(this.getFp()-1);
    };

    /**
     * Base hammer attack.
     *
     * @param anEnemy the an enemy
     */
    protected void baseHammerAttack(Enemy anEnemy){
        int damage = (int) Math.round(1.5 * this.getAtk() * (this.getLvl() / (double) anEnemy.getDef()));
        anEnemy.hammerAttacked(damage, this);
        this.setFp(this.getFp()-2);
    }

    /**
     * Hammer attack.
     *
     * @param anEnemy the an enemy
     */
    protected void hammerAttack(Enemy anEnemy){
        this.getState().hammerAttack();
        int rand = this.random.nextInt(4);
        if (rand==0){
            baseHammerAttack(anEnemy);
        }
    }

    /**
     * Set seed.
     *
     * @param n the n
     */
    public void setSeed(int n){
        this.random.setSeed(n);
    }

    @Override
    public void normalAttacked(int damage, Enemy anEnemy){
        this.getState().normalAttacked();
        this.setHp(this.getHp()-damage);
    };
}
