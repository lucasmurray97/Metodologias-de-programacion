package com.example.aventurasdemarcoyluis.abstractclasses;
import com.example.aventurasdemarcoyluis.classes.Alive;
import com.example.aventurasdemarcoyluis.classes.KnockedOut;
import com.example.aventurasdemarcoyluis.classes.State;
import com.example.aventurasdemarcoyluis.interfaces.Character;

import java.lang.Math;
import java.util.Objects;

/**
 * The type Abstract character. It defines the general behavior for all subclasses: Luigi,
 * Marcos, Goomba, Boo, Spiny and the abstract class protagonist. An Abstract Character is
 * defines by it's level, attack, defense, health points, maximum health points, maximum
 * attack, maximum defense and type. Besides this, every character is either knocked out,
 * meaning that it can't attack, or not.
 */
public abstract class AbstractCharacter implements Character {
    private int lvl;
    private int atk;
    private int def;
    private int hp;
    private int maxHp;
    private int maxAtk;
    private int maxDef;
    private String type;
    private int baseHp;
    private int baseAtk;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        this.state.setCharacter(this);
    }

    private int baseDef;
    private State state;

    /**
     * Instantiates a new Abstract character.
     *
     * @param lvl      the level
     * @param type     the type
     * @param aBaseHp  the base hp defined for each specific character
     * @param aBaseAtk the a base atk defined for each specific character
     * @param aBaseDef the a base def defined for each specific character
     */
    public AbstractCharacter(int lvl, String type, int aBaseHp, int aBaseAtk, int aBaseDef) {
        if(lvl<1){
            lvl = 1;
        }
        this.lvl = lvl;
        this.maxHp = (int) Math.round(aBaseHp*Math.pow(1.15,this.lvl-1));
        this.maxAtk = (int) Math.round(aBaseAtk*Math.pow(1.15,this.lvl-1));
        this.maxDef = (int) Math.round(aBaseDef*Math.pow(1.15,this.lvl-1));
        this.hp = this.maxHp;
        this.atk = this.maxAtk;
        this.def = this.maxDef;
        this.type = type;
        this.baseAtk = aBaseAtk;
        this.baseDef = aBaseDef;
        this.baseHp = aBaseHp;
        this.setState(new Alive());
        this.state.setCharacter(this);
    }

    /**
     * Gets atk.
     *
     * @return the atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Sets atk.
     *
     * @param atk the atk
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     * Gets lvl.
     *
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Sets lvl. Each level determines a character's maxhp, maxAtk and maxDef. The increase of
     *the level by one, increases each of the latter by 10%.
     *
     * @param lvl the lvl
     */
    public void setLvl(int lvl) {
        if(lvl<1){
            lvl = 1;
        }
        this.lvl = lvl;
        this.maxHp = (int) Math.round(this.baseHp*Math.pow(1.15,this.lvl-1));
        this.maxAtk = (int) Math.round(this.baseAtk*Math.pow(1.15,this.lvl-1));
        this.maxDef = (int) Math.round(this.baseDef*Math.pow(1.15,this.lvl-1));
        ;
    }

    /**
     * Gets def.
     *
     * @return the def
     */
    public int getDef() {
        return def;
    }

    /**
     * Sets def.
     *
     * @param def the def
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets max hp.
     *
     * @return the max hp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Gets max atk.
     *
     * @return the max atk
     */
    public int getMaxAtk() {
        return maxAtk;
    }

    /**
     * Gets max def.
     *
     * @return the max def
     */
    public int getMaxDef() {
        return maxDef;
    }

    /**
     * Sets hp, considering health restrictions: hp must be between 0 and maxhp. If a character's
     * health points are set beneath or equal to zero, it's state is set to Knocked Out.
     *
     * @param hp the hp
     */
    public void setHp(int hp) {
        if(hp <= 0) {
            this.state.knockOut();
            this.hp = 0;
            this.atk = 0;
        } else{
            if(this.state.isKnockedOut()){
                this.state.revive();
            }else{
                if (hp>=this.maxHp){
                    this.hp = this.maxHp;
                }else{
                    this.hp = hp;
                }
            }
        }
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @Override
    public String getType() {
        return type;
    }



    /**
     * Returns knockedout boolean. True if it's knocked out, false otherwise.
     *
     * @return the boolean
     */
    public boolean isKnockedOut() {
        return this.state.isKnockedOut();
    }
    public boolean isAlive() {
        return this.state.isAlive();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character aCharacter = (Character) o;
        return this.type.equals(aCharacter.getType());
    }

    @Override
    public String toString() {
        return "" + type + ": lvl = "+this.getLvl()+", atk = "+this.getAtk()+", def = "+this.getDef()+", hp = "+this.getDef()+", isKnockedOut = "+this.isKnockedOut();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
