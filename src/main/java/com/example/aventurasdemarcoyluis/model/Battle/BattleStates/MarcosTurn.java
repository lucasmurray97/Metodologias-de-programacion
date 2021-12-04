package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;

/**
 * State when Marcos is playing.
 */
public class MarcosTurn extends PlayerTurn {
    private AttackableByMarcos target;

    /**
     * Returns True
     * @return
     */
    @Override
    public boolean isMarcosTurn(){
        return true;
    }

    /**
     * Terminates current turn, and switches it to Over if all enemies knocked out, LuigisTurn if luigi is alive and EnemyTurn if not.
     */
    @Override
    public void terminate() {
        if (!this.anyEnemiesAlive()){
            this.changeState(new Over());
            this.getBattle().setOutcome(1);
        }
        else if (this.isLuigiAlive()){
            this.changeState(new LuigisTurn());
            this.getBattle().getState().setLuigisTurn();
        }else if(this.anyEnemiesAlive()){
            this.changeState(new EnemyTurn());
            this.getBattle().getState().setCurrent(0);
            this.getBattle().getState().setEnemyTurn();
        }
    }
    /**
     * Choose target marcos.
     *
     * @param enemy the enemy to be attacked.
     */
    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.target = enemy;
    }
    /**
     * Marcos jump attack.
     */
    @Override
    public void marcosJumpAttack(){
        this.getBattle().getMarcos().jumpAttack(this.target);
        terminate();
    }
    /**
     * Marcos hammer attack.
     */
    @Override
    public void marcosHammerAttack(){
        this.getBattle().getMarcos().hammerAttack(this.target);
        terminate();
    }

    /**
     * Prepares a Marcos Turn
     */
    @Override
    public void setMarcosTurn(){
        this.getBattle().setCurrentCharacter(this.getBattle().getMarcos());
        this.getBattle().setNextCharacter(this.getBattle().getCharacters().get(1));
    }
}
