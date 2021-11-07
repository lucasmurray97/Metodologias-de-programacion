package com.example.aventurasdemarcoyluis.Game.GameStates;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Battle.Battle;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;

/**
 * The State PreparingBattle. State the game switches before a battle. Items can be added to the bag
 * levels can be increased, score can be increased, battles can be created.
 */
public class PreparingBattle extends GameState{
    /**
     * Is preparing battle boolean. Returns true.
     *
     * @return the boolean
     */
    @Override
    public boolean isPreparingBattle() {
        return true;
    }
    /**
     * Add red mushroom.
     *
     * @param i the quantity of the item to be added.
     */
    @Override
    public void addRedMushroom(int i) {
        while(i>0) {
            this.getGame().getBagPack().addItem(new RedMushroom());
            i--;
        }
    }
    /**
     * Add honey syrup.
     *
     * @param i the quantity of the item to be added.
     */
    @Override
    public void addHoneySyrup(int i) {
        while(i>0) {
            this.getGame().getBagPack().addItem(new HoneySyrup());
            i--;
        }
    }
    /**
     * Creates battle.
     *
     * @param i is the number of random enemies to be added.
     */
    @Override
    public void createBattle(int i){
        Battle battle = new Battle(i, 1, this.getGame().getBagPack(), this.getGame().getLuigi(), this.getGame().getMarcos());
        this.getGame().setState(new InBattle());
        this.getGame().getState().setBattle(battle);
        this.getGame().getLuigi().getState().revive();
        this.getGame().getMarcos().getState().revive();
    }
    /**
     * Creates empty battle.
     */
    @Override
    public void createBattle(){
        Battle battle = new Battle();
        battle.setBagPack(new BagPack());
        battle.addMarcos(this.getGame().getMarcos());
        battle.addLuigi(this.getGame().getLuigi());
        battle.getState().setMarcosTurn();
        this.getGame().setState(new InBattle());
        this.getGame().getState().setBattle(battle);
        this.getGame().getLuigi().getState().revive();
        this.getGame().getMarcos().getState().revive();
    }
    /**
     * Level up. Increases player's level.
     */
    @Override
    public void levelUp(){
        this.getGame().getLuigi().setLvl(this.getGame().getLuigi().getLvl()+1);
        this.getGame().getMarcos().setLvl(this.getGame().getMarcos().getLvl()+1);
    }
    /**
     * Increase score.
     */
    @Override
    public void increaseScore() {
        this.getGame().setScore(this.getGame().getScore()+1);
        if(this.getGame().getScore()==5){
            this.getGame().setState(new Won());
        }
    }
}
