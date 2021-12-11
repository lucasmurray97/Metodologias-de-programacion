package com.example.aventurasdemarcoyluis.model.Characters;

import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Characters.States.CharacterState;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.KnockedOutHandler;

/**
 * Interface for general characters, implemented by Luigi, Marcos, Boo, Spiny and Goomba.
 */
public interface Character {
    /**
     * Gets type.
     *
     * @return the type
     */
    String getType();

    /**
     * Sets state.
     *
     * @param characterState the state
     */
    void setState(CharacterState characterState);

    /**
     * Sets hp.
     *
     * @param i the
     */
    void setHp(int i);

    /**
     * Sets atk.
     *
     * @param i the
     */
    void setAtk(int i);

    /**
     * Gets max hp.
     *
     * @return the max hp
     */
    int getMaxHp();

    /**
     * Gets max atk.
     *
     * @return the max atk
     */
    int getMaxAtk();

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    boolean isAlive();

    /**
     * Is knocked out boolean.
     *
     * @return the boolean
     */
    boolean isKnockedOut();

    /**
     * Gets atk.
     *
     * @return the atk
     */
    int getAtk();

    /**
     * Gets lvl.
     *
     * @return the lvl
     */
    int getLvl();

    /**
     * Method fired by the observer.
     *
     * @param battle   the battle
     * @param newValue the new value
     */
    void onDeath(Battle battle, int newValue);

    /**
     * Adds Knockout observer.
     *
     * @param resp the resp
     */
    void addObserver(KnockedOutHandler resp);
}
