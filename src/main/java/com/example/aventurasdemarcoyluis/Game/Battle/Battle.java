package com.example.aventurasdemarcoyluis.Game.Battle;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.Characters.Players.*;
import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.MarcosTurn;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Battle.
 */
public class Battle {
    private ArrayList<Character> characters;
    private BagPack bag;
    private BattleState state;
    private Luigi luigi;
    private Marcos marcos;
    private ArrayList<Enemy> enemies;
    private ArrayList<Player> players;

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    private int outcome;

    public Random getRandom() {
        return random;
    }

    private Random random;
    private Character currentPlayer;

    /**
     * Instantiates a new Battle.
     *
     * @param randomEnemies the random enemies
     * @param aBag          the a bag
     * @param luigi         the luigi
     * @param marcos        the marcos
     */
    public Battle(int randomEnemies, BagPack aBag, Luigi luigi, Marcos marcos) {
        this.outcome = 0;
        this.bag = aBag;
        this.luigi = luigi;
        this.marcos = marcos;
        this.random = new Random();
        this.enemies = new ArrayList<Enemy>();
        this.players = new ArrayList<Player>();
        this.characters = new ArrayList<Character>();
        this.players.add(marcos);
        this.players.add(luigi);
        this.characters.add(marcos);
        this.characters.add(luigi);
        for(int i=0; i<randomEnemies; i++){
            int randomNumber = random.nextInt(3);
            if (randomNumber == 0){
                enemies.add(new Goomba(1));
                characters.add(new Goomba(1));
            }else if(randomNumber == 1){
                enemies.add(new Boo(1));
                characters.add(new Boo(1));
            }else{
                enemies.add(new Spiny(1));
                characters.add(new Spiny(1));
            }
        }
        this.setState(new MarcosTurn());
        this.setCurrentCharacter(marcos);
    }


    /**
     * Sets state.
     *
     * @param aState the a state
     */
    public void setState(BattleState aState) {
        this.state = aState;
        this.state.setBattle(this);
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public BattleState getState() {
        return this.state;
    }

    /**
     * Gets characters.
     *
     * @return the characters
     */
    public ArrayList<Character> getCharacters() {
        return this.characters;
    }

    /**
     * Add character.
     *
     * @param aCharacter the a character
     */
    public void addCharacter(Character aCharacter){
        characters.add(aCharacter);
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
     * Is over boolean.
     *
     * @return the boolean
     */
    public boolean isOver() {
        return this.state.isOver();
    }

    /**
     * Gets outcome.
     *
     * @return the outcome
     */
    public int getOutcome() {
        return this.outcome;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public Character getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Sets current character.
     *
     * @param aCharacter the a character
     */
    public void setCurrentCharacter(Character aCharacter) {
        this.currentPlayer = aCharacter ;
        this.state.setCurrentCharacter(aCharacter);
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
     * Choose target marcos.
     *
     * @param enemy the enemy
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
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
    public void choosePlayer(Player aPlayer) {
        this.state.choosePlayer(aPlayer);
    }

    /**
     * Sets seed.
     */
    public void setSeed(int n) {
        this.random.setSeed(n);
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Is luigis turn boolean.
     *
     * @return the boolean
     */
    public boolean isLuigisTurn() {
        return this.state.isLuigisTurn();
    }

    /**
     * Is marcos turn boolean.
     *
     * @return the boolean
     */
    public boolean isMarcosTurn() {
        return this.state.isMarcosTurn();
    }

    /**
     * Pass.
     */
    public void pass() {
        this.state.pass();
    }

    /**
     * Is enemy turn boolean.
     *
     * @return the boolean
     */
    public boolean isEnemyTurn() {
        return this.state.isEnemyTurn();
    }

    /**
     * Gets enemies.
     *
     * @return the enemies
     */
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    /**
     * Check survivors.
     */
    public void checkSurvivors(){
        for (Enemy enemy: this.getEnemies()) {
            if (enemy.isKnockedOut()) {
                this.getEnemies().remove(enemy);
                this.getCharacters().remove(enemy);
            }
        }
        for (Player player: this.getPlayers()) {
            if (player.isKnockedOut()) {
                this.getEnemies().remove(player);
                this.getCharacters().remove(player);
            }
        }
    }

    /**
     * Get luigi luigi.
     *
     * @return the luigi
     */
    public Luigi getLuigi(){
        return this.luigi;
    }

    /**
     * Get marcos marcos.
     *
     * @return the marcos
     */
    public Marcos getMarcos(){
        return this.marcos;
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() {
        this.state.marcosJumpAttack();
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack() {
        this.state.luigiJumpAttack();
    }

    /**
     * Normal attack.
     */
    public void normalAttack() {
        this.state.normalAttack();
    }

    /**
     * Random attack.
     */
    public void randomAttack() {
        this.state.randomAttack();
    }
}


