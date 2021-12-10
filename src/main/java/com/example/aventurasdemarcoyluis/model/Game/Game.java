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
    public void addRedMushroom(int i) {
        try {
            this.state.addRedMushroom(i);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Add honey syrup.
     *
     * @param i the is the quantity of the item to be added.
     */
    public void addHoneySyrup(int i) {
        try {
            this.state.addHoneySyrup(i);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a battle.
     *
     * @param i is the number of random enemies to be created.
     */
    public void createBattle(int i) {
        try {
            this.state.createBattle(i);
        }catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates an "empty battle", intended for enemies to be added manually.
     */
    public void createBattle() {
        try {
            this.state.createBattle();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Get battle battle.
     *
     * @return the battle
     */
    public IBattle getBattle(){
        try {
            return this.state.getBattle();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
            return new NullBattle();
        }
    }

    /**
     * Choose target marcos. Picks the enemy to be attacked.
     *
     * @param enemy the enemy
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        try {
            this.state.chooseTargetMarcos(enemy);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() {
        try {
            this.state.marcosJumpAttack();
        } catch (InvalidGamePlay | InvalidCharacterActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Normal attack, performed by an enemy.
     */
    public void normalAttack() {
        try {
            this.state.normalAttack();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Choose target luigi. Picks the enemy to be attacked.
     *
     * @param enemy the enemy
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        try {
            this.state.chooseTargetLuigi(enemy);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack() {
        try {
            this.state.luigiJumpAttack();
        } catch (InvalidGamePlay | InvalidCharacterActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get characters array list.
     *
     * @return the array list
     */
    public ArrayList<Character> getCharacters(){
        try {
            return this.state.getCharacters();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Get current player character, if in battle.
     *
     * @return the character
     */
    public Character getCurrentPlayer(){
        try {
            return this.state.getCurrentPlayer();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
            return new NullCharacter();
        }
    }

    /**
     * Get next player character, if in battle.
     *
     * @return the character
     */
    public Character getNextPlayer(){
        try {
            return this.state.getNextCharacter();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
            return new NullCharacter();
        }
    }


    /**
     * Adds a random enemy.
     *
     * @param level the level of the random enemie.
     */
    public void addRandomEnemy(int level){
        try {
            this.state.addRandomEnemy(level);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
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
        try {
            this.state.marcosHammerAttack();
        } catch (InvalidGamePlay | InvalidCharacterActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack() {
        try {
            this.state.luigiHammerAttack();
        } catch (InvalidGamePlay | InvalidCharacterActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Chooses an item to be used.
     *
     * @param str the str
     */
    public void chooseItem(String str) {
        try {
            this.state.chooseItem(str);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Chooses a player for the item to take effect on.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer){
        try {
            this.state.choosePlayer(aPlayer);
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates current turn, if in battle.
     */
    public void terminate() {
        try {
            this.state.terminate();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Level up, increases the players level by one.
     */
    public void levelUp() {
        try {
            this.state.levelUp();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
    }

    /**
     * Increase score. Increases the score by one.
     */
    public void increaseScore() {
        try {
            this.state.increaseScore();
        } catch (InvalidGamePlay e) {
            e.printStackTrace();
        }
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
