package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;

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
        //this.battle.checkSurvivors();
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
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    void error() throws InvalidGamePlay {
        throw new InvalidGamePlay("Wrong State");
    }

    /**
     * Terminates current turn.
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void terminate() throws InvalidGamePlay {
        error();
    }

    /**
     * Chooses an item.
     *
     * @param str the item
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void chooseItem(String str) throws InvalidGamePlay {
        error();
    }


    /**
     * Choose target marcos.
     *
     * @param enemy the enemy to be attacked.
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay {
        error();
    }

    /**
     * Choose target luigi.
     *
     * @param enemy the enemy to be attacked.
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay {
        error();
    }


    /**
     * Choose a player for the item to take effect.
     *
     * @param aPlayer the player
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void choosePlayer(Player aPlayer) throws InvalidGamePlay {
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
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void setEnemyTurn() throws InvalidGamePlay {
        error();
    }

    /**
     * Normal attack performed by an enemy.
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void normalAttack() throws InvalidGamePlay {
        error();
    }

    /**
     * Marcos jump attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    public void marcosJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        error();
    }

    /**
     * Luigi jump attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    public void luigiJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        error();
    }

    /**
     * Marcos hammer attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    public void marcosHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        error();
    }

    /**
     * Luigi hammer attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    public void luigiHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        error();
    }

    /**
     * Sets current count for enemies turn.
     *
     * @param i the count
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void setCurrent(int i) throws InvalidGamePlay {
        error();
    }

    /**
     * Gets current count for enemies.
     *
     * @return the current count.
     * @throws InvalidGamePlay the invalid game play exception
     */
    public int getCurrent() throws InvalidGamePlay {
        error();
        return 0;
    }

    /**
     * Prepares marcos turn.
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void setMarcosTurn() throws InvalidGamePlay {
        error();
    }

    /**
     * Prepares luigis turn.
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    public void setLuigisTurn() throws InvalidGamePlay {
        error();
    }

}
