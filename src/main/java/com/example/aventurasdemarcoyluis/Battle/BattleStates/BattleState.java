package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Battle.Battle;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * The type Battle state.
 */
public class BattleState {
    private Character currentCharacter;
    private Battle battle;

    /**
     * Sets battle.
     *
     * @param aBattle the a battle
     */
    public void setBattle(Battle aBattle) {
        this.battle = aBattle;
    }

    /**
     * Get battle battle.
     *
     * @return the battle
     */
    public Battle getBattle(){
        return this.battle;
    }

    /**
     * Change state.
     *
     * @param aState the a state
     */
    public void changeState(BattleState aState){
        this.battle.setState(aState);
        this.battle.checkSurvivors();
    }

    /**
     * Set current character.
     *
     * @param aCharacter the a character
     */
    public void setCurrentCharacter(Character aCharacter){
        this.currentCharacter = aCharacter;
    }

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public boolean isOver() {
        return false;
    }

    /**
     * Is marcos turn boolean.
     *
     * @return the boolean
     */
    public boolean isMarcosTurn() {
        return false;
    }

    /**
     * Is luigis turn boolean.
     *
     * @return the boolean
     */
    public boolean isLuigisTurn() {
        return false;
    }

    /**
     * Is enemy turn boolean.
     *
     * @return the boolean
     */
    public boolean isEnemyTurn() {
        return false;
    }

    /**
     * Is player turn boolean.
     *
     * @return the boolean
     */
    public boolean isPlayerTurn() {
        return false;
    }

    /**
     * Is boo turn boolean.
     *
     * @return the boolean
     */
    public boolean isBooTurn() {
        return false;
    }

    /**
     * Is goomba turn boolean.
     *
     * @return the boolean
     */
    public boolean isGoombaTurn() {
        return false;
    }

    /**
     * Is spiny turn boolean.
     *
     * @return the boolean
     */
    public boolean isSpinyTurn() {
        return false;
    }

    /**
     * Error.
     */
    void error(){
        throw new AssertionError("Wrong State");
    }

    /**
     * Pass.
     */
    public void terminate() {
        error();
    }

    /**
     * Choose item.
     *
     * @param str the str
     */
    public void chooseItem(String str) {
        error();
    }


    /**
     * Choose target marcos.
     *
     * @param enemy the enemy
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        error();
    }

    /**
     * Choose target luigi.
     *
     * @param enemy the enemy
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        error();
    }


    /**
     * Choose player.
     *
     * @param aPlayer the a player
     */
    public void choosePlayer(Player aPlayer) {
        error();
    }

    /**
     * Is luigi alive boolean.
     *
     * @return the boolean
     */
    public boolean isLuigiAlive(){
        return this.battle.getLuigi().isAlive();
    }

    /**
     * Is marcos alive boolean.
     *
     * @return the boolean
     */
    public boolean isMarcosAlive(){
        return this.battle.getMarcos().isAlive();
    }

    /**
     * Any enemies alive boolean.
     *
     * @return the boolean
     */
    public boolean anyEnemiesAlive(){
        for (Enemy enemy: this.battle.getEnemies()) {
            if (enemy.isAlive()) {
                return true;
            }
        }
        return false;

    }

    /**
     * Get current character character.
     *
     * @return the character
     */
    public Character getCurrentCharacter(){
        return this.currentCharacter;
    }

    /**
     * Random attack.
     */
    public void setEnemyTurn(){
        error();
    }

    /**
     * Normal attack.
     */
    public void normalAttack() {
        error();
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack(){
        error();
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack(){
        error();
    }

    /**
     * Marcos hammer attack.
     */
    public void marcosHammerAttack(){
        error();
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack(){
        error();
    }

    /**
     * Sets current.
     *
     * @param i the
     */
    public void setCurrent(int i) {
        error();
    }

    /**
     * Gets current.
     *
     * @return the current
     */
    public int getCurrent() {
        error();
        return 0;
    }

    /**
     * Set marcos turn.
     */
    public void setMarcosTurn(){
        error();
    }

    /**
     * Set luigis turn.
     */
    public void setLuigisTurn(){
        error();
    }
}
