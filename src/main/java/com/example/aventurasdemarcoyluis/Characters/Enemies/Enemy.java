package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.Battle.BattleStates.EnemyTurn;

/**
 * The interface Enemy, implemented by Boo, Spiny and Goomba.
 */
public interface Enemy extends Character {

    /**
     * Gets def.
     *
     * @return the def
     */
    int getDef();

    /**
     * Hammer attacked.
     *
     * @param damage  the damage
     * @param aPlayer the a player
     */
    void hammerAttacked(int damage, Player aPlayer);

    /**
     * Jump attacked.
     *
     * @param damage  the damage
     * @param aPlayer the a player
     */
    void jumpAttacked(int damage, Player aPlayer);
    boolean isAlive();
    boolean isKnockedOut();

    /**
     * My turn enemy turn.
     *
     * @return the enemy turn
     */
    EnemyTurn myTurn();
}
