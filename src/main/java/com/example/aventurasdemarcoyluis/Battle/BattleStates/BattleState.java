package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Battle.Battle;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * A generic State of a Battle.
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
     * Get battle.
     *
     * @return the battle
     */
    public Battle getBattle(){
        return this.battle;
    }

    /**
     * Changes state of the battle.
     *
     * @param aState the state the battle switches to
     */
    public void changeState(BattleState aState){
        this.battle.setState(aState);
        this.battle.checkSurvivors();
    }

    /**
     * Set current character.
     *
     * @param aCharacter the character
     */
    public void setCurrentCharacter(Character aCharacter){
        this.currentCharacter = aCharacter;
    }

    /**
     * Is over boolean. True if battle is over.
     *
     * @return the boolean
     */
    public boolean isOver() {
        return false;
    }

    /**
     * Is marcos turn boolean. True if it's Marcos' turn to play
     *
     * @return the boolean
     */
    public boolean isMarcosTurn() {
        return false;
    }

    /**
     * Is luigis turn boolean. True if it's luigi's turn to play.
     *
     * @return the boolean
     */
    public boolean isLuigisTurn() {
        return false;
    }

    /**
     * Is enemy turn boolean. True if an Enemy is playing.
     *
     * @return the boolean
     */
    public boolean isEnemyTurn() {
        return false;
    }

    /**
     * Is player turn boolean. True if a it's a players turn to play.
     *
     * @return the boolean
     */
    public boolean isPlayerTurn() {
        return false;
    }

    /**
     * Is boo turn boolean. True if it's a boo's turn to play.
     *
     * @return the boolean
     */
    public boolean isBooTurn() {
        return false;
    }

    /**
     * Is goomba turn boolean. True if it's a Gooomba's turn to play.
     *
     * @return the boolean
     */
    public boolean isGoombaTurn() {
        return false;
    }

    /**
     * Is spiny turn boolean. True if it's a Spiny's turn to play.
     *
     * @return the boolean
     */
    public boolean isSpinyTurn() {
        return false;
    }

    /**
     * Throws an assertion error with the message "Wrong State"
     */
    void error(){
        throw new AssertionError("Wrong State");
    }

    /**
     * Terminates current turn.
     */
    public void terminate() {
        error();
    }

    /**
     * Chooses an item.
     *
     * @param str the item
     */
    public void chooseItem(String str) {
        error();
    }


    /**
     * Choose target marcos.
     *
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        error();
    }

    /**
     * Choose target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        error();
    }


    /**
     * Choose a player for the item to take effect.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer) {
        error();
    }

    /**
     * Is luigi alive boolean. True Luigi is alive.
     *
     * @return the boolean
     */
    public boolean isLuigiAlive(){
        return this.battle.getLuigi().isAlive();
    }

    /**
     * Is marcos alive boolean. True if Marcos is alive.
     *
     * @return the boolean
     */
    public boolean isMarcosAlive(){
        return this.battle.getMarcos().isAlive();
    }

    /**
     * Any enemies alive boolean. True if any enemies alive in the battle.
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
     * Get current character. The one playing.
     *
     * @return the character
     */
    public Character getCurrentCharacter(){
        return this.currentCharacter;
    }

    /**
     * Prepares an enemy turn.
     */
    public void setEnemyTurn(){
        error();
    }

    /**
     * Normal attack performed by an enemy.
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
     * Sets current count for enemies turn.
     *
     * @param i the count
     */
    public void setCurrent(int i) {
        error();
    }

    /**
     * Gets current count for enemies.
     *
     * @return the current count.
     */
    public int getCurrent() {
        error();
        return 0;
    }

    /**
     * Prepares marcos turn.
     */
    public void setMarcosTurn(){
        error();
    }

    /**
     * Prepares luigis turn.
     */
    public void setLuigisTurn(){
        error();
    }
}
