package com.example.aventurasdemarcoyluis.abstractclasses;

import com.example.aventurasdemarcoyluis.classes.BagPack;
import com.example.aventurasdemarcoyluis.classes.Boo;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;
import com.example.aventurasdemarcoyluis.interfaces.Item;
import com.example.aventurasdemarcoyluis.interfaces.Player;
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
     * Instantiates a new Protagonist, setting it's fp to 0.
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
        this.bag = new BagPack(this);
        this.random = new Random();
    }

    /**
     * Picks up an item and stores it in the bagpack.
     * @param anItem the item that is picked up.
     */
    public void pickItem(Item anItem) {
        bag.pickItem(anItem);

    }

    /**
     * Uses item an item.
     *
     * @param anItem item being used.
     */
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

    protected void jumpAttack(Enemy anEnemy){
        int damage = this.getAtk() * (this.getLvl() / anEnemy.getDef());
        anEnemy.jumpAttacked(damage, this);
        this.setFp(this.getFp()-1);
    };

    protected void baseHammerAttack(Enemy anEnemy){
        int damage = (int) (1.5 * this.getAtk() * (this.getLvl() / anEnemy.getDef()));
        anEnemy.hammerAttacked(damage, this);
        this.setFp(this.getFp()-2);
    }
    protected void hammerAttack(Enemy anEnemy){
        if (this.random.nextInt(4)==0){
            baseHammerAttack(anEnemy);
        }
    }

    public void setSeed(int n){
        this.random.setSeed(n);
    }

    @Override
    public void normalAttacked(int damage, Enemy anEnemy){
        this.setHp(this.getHp()-damage);
    };
}
