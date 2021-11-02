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
    private int outcome;
    private Random random;
    private Character currentPlayer;
    private Character NextPlayer;

    /**
     * Instantiates a new Battle.
     *
     * @param randomEnemies the random enemies
     * @param level         the level
     * @param aBag          the a bag
     * @param luigi         the luigi
     * @param marcos        the marcos
     */
    public Battle(int randomEnemies, int level, BagPack aBag, Luigi luigi, Marcos marcos) {
        this.outcome = 0;
        this.bag = aBag;
        this.luigi = luigi;
        this.marcos = marcos;
        this.random = new Random();
        this.enemies = new ArrayList<Enemy>();
        this.players = new ArrayList<Player>();
        this.characters = new ArrayList<Character>();
        this.addPlayer(marcos);
        this.addPlayer(luigi);
        for(int i=0; i<randomEnemies; i++){
            this.addRandomEnemy(level);
        }
        this.setState(new MarcosTurn());
        this.setCurrentCharacter(marcos);
        this.setNextCharacter(luigi);
    }

    public void setNextCharacter(Character aCharacter) {
        this.NextPlayer = aCharacter;
    }

    /**
     * Instantiates a new Battle.
     */
    public Battle() {
        this.outcome = 0;
        this.random = new Random();
        this.enemies = new ArrayList<Enemy>();
        this.players = new ArrayList<Player>();
        this.characters = new ArrayList<Character>();
        this.setState(new MarcosTurn());
    }

    /**
     * Gets random.
     *
     * @return the random
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Sets random.
     *
     * @param random the random
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * Sets outcome.
     *
     * @param outcome the outcome
     */
    public void setOutcome(int outcome) {
        this.outcome = outcome;
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
     * Sets bag pack.
     *
     * @param aBag the a bag
     */
    public void setBagPack(BagPack aBag) {
        this.bag = aBag;
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
     *
     * @param n the n
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
        int n = this.getEnemies().size();
        for(int i = 0; i<n; i++){
            if (this.getEnemies().get(i).isKnockedOut()) {
                this.getCharacters().remove(this.getEnemies().get(i));
                this.getEnemies().remove(this.getEnemies().get(i));
                i--;
                n--;
            }
        }
        int m = this.getPlayers().size();
        for (int i = 0; i<m;i++) {
            if (this.getPlayers().get(i).isKnockedOut()) {
                this.getCharacters().remove(this.getPlayers().get(i));
                this.getPlayers().remove(this.getPlayers().get(i));
                i--;
                m--;
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
     * Is boo turn boolean.
     *
     * @return the boolean
     */
    public boolean isBooTurn() {
        return this.state.isBooTurn();
    }

    /**
     * Is goomba turn boolean.
     *
     * @return the boolean
     */
    public boolean isGoombaTurn() {
        return this.state.isGoombaTurn();
    }

    /**
     * Is spiny turn boolean.
     *
     * @return the boolean
     */
    public boolean isSpinyTurn() {
        return this.state.isSpinyTurn();
    }

    /**
     * Is player turn boolean.
     *
     * @return the boolean
     */
    public boolean isPlayerTurn() {
        return state.isPlayerTurn();
    }

    /**
     * Add enemy.
     *
     * @param anEnemy the an enemy
     */
    public void addEnemy(Enemy anEnemy) {
        this.getEnemies().add(anEnemy);
        this.addCharacter(anEnemy);
    }

    /**
     * Add player.
     *
     * @param aPlayer the a player
     */
    public void addPlayer(Player aPlayer) {
        this.getPlayers().add(aPlayer);
        this.addCharacter(aPlayer);
    }

    /**
     * Add random enemy.
     *
     * @param level the level
     */
    public void addRandomEnemy(int level) {
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0){
            this.addEnemy(new Goomba(level));
        }else if(randomNumber == 1){
            this.addEnemy(new Boo(level));
        }else{
            this.addEnemy(new Spiny(level));
        }
    }

    public Character getNextCharacter() {
        return this.NextPlayer;
    }
}


