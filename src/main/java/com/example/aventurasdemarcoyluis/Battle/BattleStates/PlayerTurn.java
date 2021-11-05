package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * The type Player turn.
 */
public class PlayerTurn extends BattleState {
    private String item;
    @Override
    public boolean isPlayerTurn(){
        return true;
    }
    @Override
    public void chooseItem(String str) {
        this.item = str;
    }
    @Override
    public void choosePlayer(Player aPlayer) {
        if(aPlayer.isAlive()) {
            aPlayer.useItem(this.item);
        }
        this.terminate();
    }
}
