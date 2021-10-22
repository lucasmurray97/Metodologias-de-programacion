package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.Player;

public class PlayerTurn extends BattleState{
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
        aPlayer.useItem(this.item);
        this.pass();
    }
}
