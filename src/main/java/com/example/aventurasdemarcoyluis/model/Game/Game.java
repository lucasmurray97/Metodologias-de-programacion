package com.example.aventurasdemarcoyluis.model.Game;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.IBattle;
import com.example.aventurasdemarcoyluis.model.Battle.NullBattle;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.NullCharacter;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.GameStates.GameState;
import com.example.aventurasdemarcoyluis.model.Game.GameStates.PreparingBattle;
import com.example.aventurasdemarcoyluis.model.Items.Item;

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
        this.luigi = new Luigi(1, 30, 100, 50, 20);
        this.marcos = new Marcos(1, 30, 100, 50, 20);
        this.bag = new BagPack();
        this.luigi.setBag(this.bag);
        this.marcos.setBag(this.bag);
        this.setState(new PreparingBattle());
    }

    public Game(String test){
        this.score = 0;
        this.luigi = new Luigi(1, 100, 100, 100, 0);
        this.marcos = new Marcos(1, 100, 100, 100, 0);
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
    public void addRedMushroom(int i) throws InvalidGamePlay {
        this.state.addRedMushroom(i);
    }

    /**
     * Add honey syrup.
     *
     * @param i the is the quantity of the item to be added.
     */
    public void addHoneySyrup(int i) throws InvalidGamePlay {
        this.state.addHoneySyrup(i);
    }

    /**
     * Creates a battle.
     *
     * @param i is the number of random enemies to be created.
     */
    public void createBattle(int i) throws InvalidGamePlay {
        this.state.createBattle(i);
    }

    /**
     * Creates an "empty battle", intended for enemies to be added manually.
     */
    public void createBattle() throws InvalidGamePlay {
        this.state.createBattle();
    }

    /**
     * Get battle battle.
     *
     * @return the battle
     */
    public IBattle getBattle() throws InvalidGamePlay {
        return this.state.getBattle();
    }

    /**
     * Choose target marcos. Picks the enemy to be attacked.
     *
     * @param enemy the enemy
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay {
        this.state.chooseTargetMarcos(enemy);
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        this.state.marcosJumpAttack();
    }

    /**
     * Normal attack, performed by an enemy.
     */
    public void normalAttack() throws InvalidGamePlay {
        this.state.normalAttack();
    }

    /**
     * Choose target luigi. Picks the enemy to be attacked.
     *
     * @param enemy the enemy
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay {
        this.state.chooseTargetLuigi(enemy);
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        this.state.luigiJumpAttack();
    }

    /**
     * Get characters array list.
     *
     * @return the array list
     */
    public ArrayList<Character> getCharacters() throws InvalidGamePlay {
        return this.state.getCharacters();
    }

    /**
     * Get current player character, if in battle.
     *
     * @return the character
     */
    public Character getCurrentPlayer() throws InvalidGamePlay {
        return this.state.getCurrentPlayer();
    }

    /**
     * Get next player character, if in battle.
     *
     * @return the character
     */
    public Character getNextPlayer() throws InvalidGamePlay {
        return this.state.getNextCharacter();
    }


    /**
     * Adds a random enemy.
     *
     * @param level the level of the random enemie.
     */
    public void addRandomEnemy(int level) throws InvalidGamePlay {
        this.state.addRandomEnemy(level);
    }

    /**
     * Sets seed.
     *
     * @param i the
     */
    public void setSeed(int i) throws InvalidGamePlay {
        this.getBattle().setSeed(i);
    }

    /**
     * Marcos hammer attack.
     */
    public void marcosHammerAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        this.state.marcosHammerAttack();
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        this.state.luigiHammerAttack();
    }

    /**
     * Chooses an item to be used.
     *
     * @param str the str
     */
    public void chooseItem(String str) throws InvalidGamePlay {
        this.state.chooseItem(str);
    }

    /**
     * Chooses a player for the item to take effect on.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer) throws InvalidGamePlay {
        this.state.choosePlayer(aPlayer);
    }

    /**
     * Terminates current turn, if in battle.
     */
    public void terminate() throws InvalidGamePlay {
        this.state.terminate();
    }

    /**
     * Level up, increases the players level by one.
     */
    public void levelUp() throws InvalidGamePlay {
        this.state.levelUp();
    }

    /**
     * Increase score. Increases the score by one.
     */
    public void increaseScore() throws InvalidGamePlay {
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
