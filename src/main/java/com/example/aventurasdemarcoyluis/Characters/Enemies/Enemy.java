package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.EnemyTurn;

/**
 * The interface Enemy, implemented by Boo, Spiny and Goomba.
 */
public interface Enemy extends Character {

    int getDef();

    void hammerAttacked(int damage, Player aPlayer);

    void jumpAttacked(int damage, Player aPlayer);
    boolean isAlive();
    boolean isKnockedOut();

    EnemyTurn myTurn();
}
