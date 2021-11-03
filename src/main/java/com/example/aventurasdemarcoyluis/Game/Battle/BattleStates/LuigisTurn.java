package com.example.aventurasdemarcoyluis.Game.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;

/**
 * The type Luigis turn.
 */
public class LuigisTurn extends PlayerTurn {
    private AttackableByLuigi target;
    public boolean isLuigisTurn(){
        return true;
    }
    @Override
    public void terminate() {
        if (this.anyEnemiesAlive()) {
            this.changeState(new EnemyTurn());
            this.getBattle().getState().setCurrent(0);
            this.getBattle().getState().setEnemyTurn();
        } else{
            this.changeState(new Over());
            this.getBattle().setOutcome(1);
        }
    }
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.target = enemy;
    }
    @Override
    public void luigiJumpAttack(){
        this.getBattle().getLuigi().jumpAttack(this.target);
        this.terminate();
    }
    @Override
    public void luigiHammerAttack(){
        this.getBattle().getLuigi().hammerAttack(this.target);
        this.terminate();
    }
    @Override
    public void setLuigisTurn(){
        this.getBattle().setCurrentCharacter(this.getBattle().getLuigi());
        this.getBattle().setNextCharacter(this.getBattle().getEnemies().get(0));
    }
}
