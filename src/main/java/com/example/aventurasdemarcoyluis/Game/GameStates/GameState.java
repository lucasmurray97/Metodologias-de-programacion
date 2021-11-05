package com.example.aventurasdemarcoyluis.Game.GameStates;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.Battle.Battle;
import com.example.aventurasdemarcoyluis.Game.Game;

import java.util.ArrayList;

/**
 * The type Game state.
 */
public class GameState {
    private Game game;

    /**
     * Get game game.
     *
     * @return the game
     */
    public Game getGame(){
        return this.game;
    }

    /**
     * Is preparing battle boolean.
     *
     * @return the boolean
     */
    public boolean isPreparingBattle() {
        return false;
    }

    /**
     * Is in battle boolean.
     *
     * @return the boolean
     */
    public boolean isInBattle() {
        return false;
    }

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public boolean Lost() {
        return false;
    }

    /**
     * Has won boolean.
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
     * Error.
     */
    public void error(){
        throw new AssertionError("Wrong State");
    }

    /**
     * Create battle.
     *
     * @param i the
     */
    public void createBattle(int i) {
        error();
    }

    /**
     * Create battle.
     */
    public void createBattle() {
        error();
    }

    /**
     * Add random enemy.
     *
     * @param level the level
     */
    public void addRandomEnemy(int level){
        error();
    }

    /**
     * Add honey syrup.
     *
     * @param i the
     */
    public void addHoneySyrup(int i) {
        error();
    }

    /**
     * Add red mushroom.
     *
     * @param i the
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
     * Get battle battle.
     *
     * @return the battle
     */
    public Battle getBattle(){
        error();
        return null;
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
     * Marcos jump attack.
     */
    public void marcosJumpAttack() {
        error();
    }

    /**
     * Random attack.
     */
    public void normalAttack() {
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
     * Luigi jump attack.
     */
    public void luigiJumpAttack(){
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
     * Choose player.
     *
     * @param aPlayer the a player
     */
    public void choosePlayer(Player aPlayer){
        error();
    }

    /**
     * Terminate.
     */
    public void terminate() {
        error();
    }

    /**
     * Level up.
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
