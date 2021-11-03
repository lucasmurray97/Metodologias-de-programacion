package com.example.aventurasdemarcoyluis.Game.GameStates;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.Game.Battle.Battle;
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
    public boolean isOver() {
        return false;
    }
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

    public void createBattle() {
        error();
    }
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

    public void chooseItem(String str) {
        error();
    }
    public void choosePlayer(Player aPlayer){
        error();
    }
    public void terminate() {
        error();
    }
    public void levelUp(){
        error();
    }

    public ArrayList<Character> getCharacters() {
        error();
        return null;
    }

    public Character getCurrentPlayer() {
        error();
        return null;
    }
    public Character getNextCharacter() {
        error();
        return null;
    }

    public void checkBattleState() {
        error();
    }

    public void increaseScore() {
        error();
    }

    public void marcosHammerAttack() {
        error();
    }
    public void luigiHammerAttack() {
        error();
    }
}
