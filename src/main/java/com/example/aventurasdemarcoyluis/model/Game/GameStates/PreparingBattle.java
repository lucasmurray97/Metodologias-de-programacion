package com.example.aventurasdemarcoyluis.model.Game.GameStates;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.BattleOverHandler;
import com.example.aventurasdemarcoyluis.model.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.Items.RedMushroom;

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
     * @param i is the number of random enemies to be added. Adds the battle over observer.
     */
    @Override
    public void createBattle(int i) throws InvalidGamePlay {
        Battle battle = new Battle(i, 1, this.getGame().getBagPack(), this.getGame().getLuigi(), this.getGame().getMarcos());
        this.getGame().setState(new InBattle());
        battle.addObserver(new BattleOverHandler((InBattle) this.getGame().getState()));
        this.getGame().getState().setBattle(battle);
        this.getGame().getLuigi().revive();
        this.getGame().getMarcos().revive();
    }
    /**
     * Creates empty battle. Adds the battle over observer.
     */
    @Override
    public void createBattle() throws InvalidGamePlay {
        Battle battle = new Battle();
        battle.setBagPack(new BagPack());
        battle.addMarcos(this.getGame().getMarcos());
        battle.addLuigi(this.getGame().getLuigi());
        battle.getState().setMarcosTurn();
        this.getGame().setState(new InBattle());
        battle.addObserver(new BattleOverHandler((InBattle) this.getGame().getState()));
        this.getGame().getState().setBattle(battle);
        this.getGame().getLuigi().revive();
        this.getGame().getMarcos().revive();
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
