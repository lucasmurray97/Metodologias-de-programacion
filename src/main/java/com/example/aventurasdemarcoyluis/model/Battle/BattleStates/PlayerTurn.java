package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;

/**
 * The type Player turn.
 */
public class PlayerTurn extends BattleState {
    private String item;

    /**
     * Returns True
     * @return
     */
    @Override
    public boolean isPlayerTurn(){
        return true;
    }

    /**
     * Chooses an item to be used.
     * @param str the item
     */
    @Override
    public void chooseItem(String str) {
        this.item = str;
    }

    /**
     * Chooses a player for the item to take effect on.
     * @param aPlayer the player
     */
    @Override
    public void choosePlayer(Player aPlayer) {
        if(aPlayer.isAlive()) {
            aPlayer.useItem(this.item);
        }
        this.terminate();
    }
}
