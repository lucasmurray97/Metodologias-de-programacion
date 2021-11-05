package com.example.aventurasdemarcoyluis.Game;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.*;
import com.example.aventurasdemarcoyluis.Battle.Battle;
import com.example.aventurasdemarcoyluis.Game.GameStates.GameState;
import com.example.aventurasdemarcoyluis.Game.GameStates.PreparingBattle;
import com.example.aventurasdemarcoyluis.Items.Item;

import java.util.ArrayList;

/**
 * The type Game.
 */
public class Game {
    private BagPack bag;
    private GameState state;
    private Luigi luigi;
    private Marcos marcos;
    /**
     * The Score.
     */
    int score;

    /**
     * Instantiates a new Game.
     */
    public Game(){
        this.score = 0;
        this.luigi = new Luigi(1);
        this.marcos = new Marcos(1);
        this.bag = new BagPack();
        this.luigi.setBag(this.bag);
        this.marcos.setBag(this.bag);
        this.setState(new PreparingBattle());
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(GameState state) {
        this.state = state;
        this.state.setGame(this);
    }

    /**
     * Sets score.
     *
     * @param points the points
     */
    public void setScore(int points) {
        this.score = points;
    }

    /**
     * Get score int.
     *
     * @return the int
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Gets luigi.
     *
     * @return the luigi
     */
    public Luigi getLuigi() {
        return this.luigi;
    }

    /**
     * Gets marcos.
     *
     * @return the marcos
     */
    public Marcos getMarcos() {
        return this.marcos;
    }

    /**
     * Gets bag pack.
     *
     * @return the bag pack
     */
    public BagPack getBagPack() {
        return this.bag;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public GameState getState() {
        return this.state;
    }

    /**
     * Add red mushroom.
     *
     * @param i the
     */
    public void addRedMushroom(int i) {
        this.state.addRedMushroom(i);
    }

    /**
     * Add honey syrup.
     *
     * @param i the
     */
    public void addHoneySyrup(int i) {
        this.state.addHoneySyrup(i);
    }

    /**
     * Create battle.
     *
     * @param i the
     */
    public void createBattle(int i) {
        this.state.createBattle(i);
    }

    /**
     * Create battle.
     */
    public void createBattle() {
        this.state.createBattle();
    }

    /**
     * Get battle battle.
     *
     * @return the battle
     */
    public Battle getBattle(){
        return this.state.getBattle();
    }

    /**
     * Choose target marcos.
     *
     * @param enemy the enemy
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() {
        this.state.marcosJumpAttack();
    }

    /**
     * Normal attack.
     */
    public void normalAttack() {
        this.state.normalAttack();
    }

    /**
     * Choose target luigi.
     *
     * @param enemy the enemy
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.state.chooseTargetLuigi(enemy);
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack() {
        this.state.luigiJumpAttack();
    }

    /**
     * Get characters array list.
     *
     * @return the array list
     */
    public ArrayList<Character> getCharacters(){
        return this.state.getCharacters();
    }

    /**
     * Get current player character.
     *
     * @return the character
     */
    public Character getCurrentPlayer(){
        return this.state.getCurrentPlayer();
    }

    /**
     * Get next player character.
     *
     * @return the character
     */
    public Character getNextPlayer(){
        return this.state.getNextCharacter();
    }

    /**
     * Check battle state.
     */
    public void checkBattleState(){
        this.state.checkBattleState();
    }

    /**
     * Add random enemy.
     *
     * @param level the level
     */
    public void addRandomEnemy(int level){
        this.state.addRandomEnemy(level);
    }

    /**
     * Sets seed.
     *
     * @param i the
     */
    public void setSeed(int i) {
        this.getBattle().setSeed(i);
    }

    /**
     * Marcos hammer attack.
     */
    public void marcosHammerAttack() {
        this.state.marcosHammerAttack();
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack() {
        this.state.luigiHammerAttack();
    }

    /**
     * Choose item.
     *
     * @param str the str
     */
    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }

    /**
     * Choose player.
     *
     * @param aPlayer the a player
     */
    public void choosePlayer(Player aPlayer){
        this.state.choosePlayer(aPlayer);
    }

    /**
     * Terminate.
     */
    public void terminate() {
        this.state.terminate();
    }

    /**
     * Level up.
     */
    public void levelUp() {
        this.state.levelUp();
    }

    /**
     * Increase score.
     */
    public void increaseScore() {
        this.state.increaseScore();
    }

    /**
     * Is in battle boolean.
     *
     * @return the boolean
     */
    public boolean isInBattle() {
        return this.state.isInBattle();
    }

    /**
     * Has won boolean.
     *
     * @return the boolean
     */
    public boolean hasWon() {
        return this.state.hasWon();
    }

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public boolean Lost() {
        return this.state.Lost();
    }

    /**
     * Get items array list.
     *
     * @return the array list
     */
    public ArrayList<Item> getItems(){
        ArrayList<Item> iterable = new ArrayList<Item>();
        BagPack bag = this.getBagPack();
        for (Object var: bag.getBag().keySet().toArray()){
            iterable.addAll(bag.getBag().get(var));
        }
        return iterable;
    }
}
