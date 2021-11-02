package com.example.aventurasdemarcoyluis.Game;

import com.example.aventurasdemarcoyluis.Game.Battle.Battle;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;

public class PreparingBattle extends GameState{
    @Override
    public boolean isPreparingBattle() {
        return true;
    }

    @Override
    public void addRedMushroom(int i) {
        while(i>=0) {
            this.getGame().getBagPack().addItem(new RedMushroom());
            i--;
        }
    }
    @Override
    public void addHoneySyrup(int i) {
        while(i>=0) {
            this.getGame().getBagPack().addItem(new HoneySyrup());
            i--;
        }
    }
    @Override
    public void createBattle(int i){
        Battle battle = new Battle(i, 1, this.getGame().getBagPack(), this.getGame().getLuigi(), this.getGame().getMarcos());
        this.getGame().setState(new InBattle());
        this.getGame().getState().setBattle(battle);
        this.getGame().getLuigi().getState().revive();
        this.getGame().getMarcos().getState().revive();
    }
    @Override
    public void levelUp(){
        this.getGame().getLuigi().setLvl(this.getGame().getLuigi().getLvl()+1);
        this.getGame().getMarcos().setLvl(this.getGame().getMarcos().getLvl()+1);
    }
}
