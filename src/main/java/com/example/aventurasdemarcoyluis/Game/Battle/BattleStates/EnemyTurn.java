package com.example.aventurasdemarcoyluis.Game.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Enemy turn.
 */
public class EnemyTurn extends BattleState {
    private int current;
    @Override
    public void pass() {
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
            this.getBattle().setCurrentCharacter(this.getBattle().getMarcos());
            this.getBattle().setNextCharacter(this.getBattle().getCharacters().get(1));

        }else if (isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getLuigi());
            this.getBattle().setNextCharacter(this.getBattle().getEnemies().get(0));
        }
    }
    @Override
    public boolean isEnemyTurn(){
        return true;
    }
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
    public void setCurrent(int n){
        this.current = n;
    }
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
