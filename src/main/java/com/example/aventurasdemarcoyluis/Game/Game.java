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
    int score;

    /**
     * Instantiates a new Game. Main characters are created and linked to their bagpack, the state is set to preparing battle
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
     * @param i is the quantity of the item to be added.
     */
    public void addRedMushroom(int i) {
        this.state.addRedMushroom(i);
    }

    /**
     * Add honey syrup.
     *
     * @param i the is the quantity of the item to be added.
     */
    public void addHoneySyrup(int i) {
        this.state.addHoneySyrup(i);
    }

    /**
     * Creates a battle.
     *
     * @param i is the number of random enemies to be created.
     */
    public void createBattle(int i) {
        this.state.createBattle(i);
    }

    /**
     * Creates an "empty battle", intended for enemies to be added manually.
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
     * Choose target marcos. Picks the enemy to be attacked.
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
     * Normal attack, performed by an enemy.
     */
    public void normalAttack() {
        this.state.normalAttack();
    }

    /**
     * Choose target luigi. Picks the enemy to be attacked.
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
     * Get current player character, if in battle.
     *
     * @return the character
     */
    public Character getCurrentPlayer(){
        return this.state.getCurrentPlayer();
    }

    /**
     * Get next player character, if in battle.
     *
     * @return the character
     */
    public Character getNextPlayer(){
        return this.state.getNextCharacter();
    }

    /**
     * Check battle state. Weather it's over or still being played.
     */
    public void checkBattleState(){
        this.state.checkBattleState();
    }

    /**
     * Adds a random enemy.
     *
     * @param level the level of the random enemie.
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
     * Chooses an item to be used.
     *
     * @param str the str
     */
    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }

    /**
     * Chooses a player for the item to take effect on.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer){
        this.state.choosePlayer(aPlayer);
    }

    /**
     * Terminates current turn, if in battle.
     */
    public void terminate() {
        this.state.terminate();
    }

    /**
     * Level up, increases the players level by one.
     */
    public void levelUp() {
        this.state.levelUp();
    }

    /**
     * Increase score. Increases the score by one.
     */
    public void increaseScore() {
        this.state.increaseScore();
    }

    /**
     * Is in battle boolean, weather a battle is taking place.
     *
     * @return the boolean
     */
    public boolean isInBattle() {
        return this.state.isInBattle();
    }

    /**
     * Has won boolean, returns true if the players have won the game.
     *
     * @return the boolean
     */
    public boolean hasWon() {
        return this.state.hasWon();
    }

    /**
     * Lost boolean, returns true if the players lost the game.
     *
     * @return the boolean
     */
    public boolean Lost() {
        return this.state.Lost();
    }

    /**
     * Returns an array of the items currently in the bag.
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
