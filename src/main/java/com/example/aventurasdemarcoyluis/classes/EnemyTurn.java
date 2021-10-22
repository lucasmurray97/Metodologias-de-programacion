package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractEnemy;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;
import com.example.aventurasdemarcoyluis.interfaces.Player;

import java.util.ArrayList;
import java.util.Random;

public class EnemyTurn extends BattleState{
    private Random random = new Random();
    @Override
    public void pass() {
        if(isMarcosAlive()){
            this.changeState(new MarcosTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getPlayers().get(0));
        }else if (isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getPlayers().get(1));
        }else{
            this.changeState(new Over());
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
        Enemy attacker = enemies.get(this.random.nextInt(m));
        changeState(attacker.myTurn());
        this.getBattle().setCurrentCharacter(attacker);
    }
    public Random getRandom(){
        return this.random;
    }
}
