package com.example.aventurasdemarcoyluis.Game.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Enemy turn.
 */
public class EnemyTurn extends BattleState {
    private Random random;
    @Override
    public void pass() {
        if(isMarcosAlive()){
            this.changeState(new MarcosTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getMarcos());
        }else if (isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getLuigi());
        }else{
            this.changeState(new Over());
            this.getBattle().setOutcome(-1);
        }
    }
    @Override
    public boolean isEnemyTurn(){
        return true;
    }
    @Override
    public void randomAttack(){
        ArrayList<Enemy> enemies = this.getBattle().getEnemies();
        int m = enemies.size();
        Enemy attacker = enemies.get(this.getRandom().nextInt(m));
        changeState(attacker.myTurn());
        this.getBattle().setCurrentCharacter(attacker);
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
