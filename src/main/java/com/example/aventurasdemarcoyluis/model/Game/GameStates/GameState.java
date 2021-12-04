package com.example.aventurasdemarcoyluis.model.Game.GameStates;

import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Game.Game;

import java.util.ArrayList;

/**
 * Generic Game state.
 */
public class GameState {
    private Game game;

    /**
     * Gets the game.
     *
     * @return the game
     */
    public Game getGame(){
        return this.game;
    }

    /**
     * Is preparing battle boolean. True if Game in state PreparingBattle.
     *
     * @return the boolean
     */
    public boolean isPreparingBattle() {
        return false;
    }

    /**
     * Is in battle boolean. True if Game in state InBattle.
     *
     * @return the boolean
     */
    public boolean isInBattle() {
        return false;
    }

    /**
     * Lost boolean. Returns true if players lost game.
     *
     * @return the boolean
     */
    public boolean Lost() {
        return false;
    }

    /**
     * Has won boolean. Returns True if players won game.
     *
     * @return the boolean
     */
    public boolean hasWon() {
        return false;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Error. Throws an assertion error with the message "Wrong State"
     */
    public void error(){
        throw new AssertionError("Wrong State");
    }

    /**
     * Creates battle.
     *
     * @param i is the number of random enemies to be added.
     */
    public void createBattle(int i) {
        error();
    }

    /**
     * Creates empty battle.
     */
    public void createBattle() {
        error();
    }

    /**
     * Adds random enemy.
     *
     * @param level the level of the enemies to be added.
     */
    public void addRandomEnemy(int level){
        error();
    }

    /**
     * Add honey syrup.
     *
     * @param i the quantity of the item to be added.
     */
    public void addHoneySyrup(int i) {
        error();
    }

    /**
     * Add red mushroom.
     *
     * @param i the quantity of the item to be added.
     */
    public void addRedMushroom(int i) {
        error();
    }

    /**
     * Sets battle.
     *
     * @param battle the battle
     */
    public void setBattle(Battle battle) {
        error();
    }

    /**
     * Gets battle.
     *
     * @return the battle
     */
    public Battle getBattle(){
        error();
        return null;
    }

    /**
     * Chooses target marcos.
     *
     * @param enemy the enemy to be attacked
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        error();
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() {
        error();
    }

    /**
     * Normal attacked to be performed by an enemy to a random player.
     */
    public void normalAttack() {
        error();
    }

    /**
     * Chooses target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        error();
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack(){
        error();
    }

    /**
     * Chooses item to be used.
     *
     * @param str the str
     */
    public void chooseItem(String str) {
        error();
    }

    /**
     * Chooses player for the chosen item to take effect on.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer){
        error();
    }

    /**
     * Terminates current turn if in battle.
     */
    public void terminate() {
        error();
    }

    /**
     * Level up. Increases player's level.
     */
    public void levelUp(){
        error();
    }

    /**
     * Gets characters.
     *
     * @return the characters
     */
    public ArrayList<Character> getCharacters() {
        error();
        return null;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public Character getCurrentPlayer() {
        error();
        return null;
    }

    /**
     * Gets next character.
     *
     * @return the next character
     */
    public Character getNextCharacter() {
        error();
        return null;
    }

    /**
     * Check battle state.
     */
    public void checkBattleState() {
        error();
    }

    /**
     * Increase score.
     */
    public void increaseScore() {
        error();
    }

    /**
     * Marcos hammer attack.
     */
    public void marcosHammerAttack() {
        error();
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack() {
        error();
    }
}
