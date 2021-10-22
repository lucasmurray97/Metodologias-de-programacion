package com.example.aventurasdemarcoyluis.interfaces;

import com.example.aventurasdemarcoyluis.classes.State;

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

    void setState(State state);

    void setHp(int i);

    void setAtk(int i);

    int getMaxHp();

    int getMaxAtk();

    boolean isAlive();

    boolean isKnockedOut();
}
