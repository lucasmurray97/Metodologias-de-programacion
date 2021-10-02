package com.example.aventurasdemarcoyluis.interfaces;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractPlayer;

/**
 * The interface Enemy, implemented by Boo, Spiny and Goomba.
 */
public interface Enemy extends Character{

    int getDef();

    void hammerAttacked(int damage, Player aPlayer);

    void jumpAttacked(int damage, Player aPlayer);
}
