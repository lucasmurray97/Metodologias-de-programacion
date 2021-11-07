package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;

/**
 * State when Luigi is playing.
 */
public class LuigisTurn extends PlayerTurn {
    private AttackableByLuigi target;
    /**
     * Returns True
     * @return
     */
    public boolean isLuigisTurn(){
        return true;
    }
    /**
     * Terminates current turn, and switches it to Over if all enemies knocked out, EnemyTurn if not.
     */
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
    /**
     * Choose target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.target = enemy;
    }
    /**
     * Luigi jump attack.
     */
    @Override
    public void luigiJumpAttack(){
        this.getBattle().getLuigi().jumpAttack(this.target);
        this.terminate();
    }/**
     * Luigi Hammer attack.
     */

    @Override
    public void luigiHammerAttack(){
        this.getBattle().getLuigi().hammerAttack(this.target);
        this.terminate();
    }
    /**
     * Prepares a Luigi Turn
     */
    @Override
    public void setLuigisTurn(){
        this.getBattle().setCurrentCharacter(this.getBattle().getLuigi());
        this.getBattle().setNextCharacter(this.getBattle().getEnemies().get(0));
    }
}
