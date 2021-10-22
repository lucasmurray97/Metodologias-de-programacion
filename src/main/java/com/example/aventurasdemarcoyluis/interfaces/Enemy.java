package com.example.aventurasdemarcoyluis.interfaces;

import com.example.aventurasdemarcoyluis.classes.BattleState;
import com.example.aventurasdemarcoyluis.classes.EnemyTurn;

/**
 * The interface Enemy, implemented by Boo, Spiny and Goomba.
 */
public interface Enemy extends Character{

    int getDef();

    void hammerAttacked(int damage, Player aPlayer);

    void jumpAttacked(int damage, Player aPlayer);
    boolean isAlive();
    boolean isKnockedOut();

    EnemyTurn myTurn();
}
