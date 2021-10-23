package com.example.aventurasdemarcoyluis.Game.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;

/**
 * The type Marcos turn.
 */
public class MarcosTurn extends PlayerTurn {
    private AttackableByMarcos target;
    @Override
    public boolean isMarcosTurn(){
        return true;
    }
    @Override
    public void pass() {
        if (this.isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().setCurrentCharacter(this.getBattle().getLuigi());
        }else if(this.anyEnemiesAlive()){
            this.changeState(new EnemyTurn());
        }else{
            this.changeState(new Over());
            this.getBattle().setOutcome(1);
        }
    }
    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.target = enemy;
    }
    @Override
    public void marcosJumpAttack(){
        this.getBattle().getMarcos().jumpAttack(this.target);
        pass();
    }
    @Override
    public void marcosHammerAttack(){
        this.getBattle().getMarcos().hammerAttack(this.target);
        pass();
    }
}
