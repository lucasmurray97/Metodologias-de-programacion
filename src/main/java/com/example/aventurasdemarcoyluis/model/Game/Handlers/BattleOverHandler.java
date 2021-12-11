package com.example.aventurasdemarcoyluis.model.Game.Handlers;

import com.example.aventurasdemarcoyluis.model.Game.GameStates.InBattle;

import java.beans.PropertyChangeEvent;

/**
 * The type Battle over handler. Observes wheather a battle is over or not.
 */
public class BattleOverHandler implements Handler{
    private InBattle gameInBattle;

    /**
     * Instantiates a new Battle over handler.
     *
     * @param gameInBattle the game currently in battle.
     */
    public BattleOverHandler(InBattle gameInBattle) {
        this.gameInBattle = gameInBattle;
    }

    /**
     * Calls onBattleOver method when property change is fired.
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameInBattle.onBattleOver((int) evt.getNewValue());
    }
}
