package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

/**
 * State when a generic enemy is playing.
 */
public class EnemyTurn extends BattleState {
    /**
     * count to set the exact enemy that is set to play
     */
    private int current;

    /**
     * Terminates any enemy turn: if players knocked out, sets the battle to over and outcome to -1.
     * If Enemies left to play, sets the turn to the next enemy in line to play increasing the count.
     * else if Marcos alive, sets turn to MarcosTurn, else to LuigisTurn.
     */
    @Override
    public void terminate() {
        if (!isLuigiAlive() && !isMarcosAlive()){
            this.changeState(new Over());
            this.getBattle().setOutcome(-1);
        }
        else if (this.getCurrent() < this.getBattle().getEnemies().size()-1){
            int m = this.current+1;
            this.changeState(new EnemyTurn());
            this.getBattle().getState().setCurrent(m);
            this.getBattle().getState().setEnemyTurn();
        }
        else if(isMarcosAlive()){
            this.changeState(new MarcosTurn());
            this.getBattle().getState().setMarcosTurn();

        }else if (isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().getState().setLuigisTurn();
        }
    }

    /**
     * Return True
     * @return
     */
    @Override
    public boolean isEnemyTurn(){
        return true;
    }

    /**
     * Prepares a generic enemy's turn, getting current count and passing it to the next enemy to play
     * Set's generic EnemyTurn to specific enemy turn.
     */
    @Override
    public void setEnemyTurn(){
        ArrayList<Enemy> enemies = this.getBattle().getEnemies();
        Enemy attacker = enemies.get(this.getCurrent());
        int n = this.getCurrent();
        this.changeState(attacker.myTurn());
        this.getBattle().getState().setCurrent(n);
        this.getBattle().setCurrentCharacter(attacker);
        if (n == this.getBattle().getEnemies().size()-1){
            this.getBattle().setNextCharacter(this.getBattle().getCharacters().get(0));
        }else{
            this.getBattle().setNextCharacter(enemies.get(this.getCurrent()+1));
        }
    }

    /**
     * Sets current count.
     * @param n
     */
    public void setCurrent(int n){
        this.current = n;
    }

    /**
     * Gets current count.
     * @return
     */
    public int getCurrent(){
        return this.current;
    }

    /**
     * Get random random.
     *
     * @return the random
     */
    public Random getRandom(){
        return this.getBattle().getRandom();
    }
}
