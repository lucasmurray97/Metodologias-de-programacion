package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.*;

public class LuigisTurn extends PlayerTurn {
    private AttackableByLuigi target;
    public boolean isLuigisTurn(){
        return true;
    }
    @Override
    public void pass() {
        if (this.anyEnemiesAlive()) {
            this.changeState(new EnemyTurn());
        } else{
            this.changeState(new Over());
        }
    }
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.target = enemy;
    }
    @Override
    public void luigiJumpAttack(){
        this.getBattle().getLuigi().jumpAttack(this.target);
        this.pass();
    }
    @Override
    public void luigiHammerAttack(){
        this.getBattle().getLuigi().hammerAttack(this.target);
        this.pass();
    }
}
