package com.example.aventurasdemarcoyluis.Battle;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.Characters.Players.*;
import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.Battle.BattleStates.MarcosTurn;
import com.example.aventurasdemarcoyluis.Game.Game;
import com.example.aventurasdemarcoyluis.Game.Handlers.BattleOverHandler;

import java.beans.PropertyChangeSupport;
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
    private final PropertyChangeSupport atBattleOver = new PropertyChangeSupport(this);
    private Game game;

    /**
     * Instantiates a new Battle.
     *
     * @param randomEnemies the number of random enemies
     * @param level         the level
     * @param aBag          the a bag
     * @param luigi         the luigi
     * @param marcos        the marcos
     */
    public Battle(int randomEnemies, int level, BagPack aBag, Luigi luigi, Marcos marcos) {
        this.outcome = 0;
        this.bag = aBag;
        this.random = new Random();
        this.enemies = new ArrayList<Enemy>();
        this.players = new ArrayList<Player>();
        this.characters = new ArrayList<Character>();
        this.addMarcos(marcos);
        this.addLuigi(luigi);
        for(int i=0; i<randomEnemies; i++){
            this.addRandomEnemy(level);
        }
        this.setState(new MarcosTurn());
        this.getState().setMarcosTurn();
    }

    /**
     * Instantiates an empty battle.
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
     * Sets next character.
     *
     * @param aCharacter the character that goes next.
     */
    public void setNextCharacter(Character aCharacter) {
        this.NextPlayer = aCharacter;
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


    public void addObserver(BattleOverHandler resp){
        atBattleOver.addPropertyChangeListener(resp);
    }

    /**
     * Sets outcome. 1 if players won, -1 if they lost, 0 when the battle starts.
     *
     * @param outcome the outcome
     */
    public void setOutcome(int outcome) {
        this.outcome = outcome;
        atBattleOver.firePropertyChange("BATTLE_IS_OVER", 0,outcome);
    }

    /**
     * Sets state.
     *
     * @param aState the state
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
     * Adds a character to the battle.
     *
     * @param aCharacter the character
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
     * Is over boolean. True if battle is over.
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
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.state.chooseTargetLuigi(enemy);
    }

    /**
     * Choose target marcos.
     *
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
    }

    /**
     * Chooses an item.
     *
     * @param str the item
     */
    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }

    /**
     * Choose a player for the item to take effect.
     *
     * @param aPlayer the player
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
     * Gets players currently fighting.
     *
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Is luigis turn boolean. True if it's luigi's turn to play.
     *
     * @return the boolean
     */
    public boolean isLuigisTurn() {
        return this.state.isLuigisTurn();
    }

    /**
     * Is marcos turn boolean. True if it's Marcos' turn to play
     *
     * @return the boolean
     */
    public boolean isMarcosTurn() {
        return this.state.isMarcosTurn();
    }

    /**
     * Terinates current turn.
     */
    public void terminate() {
        this.state.terminate();
    }

    /**
     * Is enemy turn boolean. True if an Enemy is playing.
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
     * Check survivors. Updates characters, enemies and players currently in battle, removing knocked out ones.
     */
    public void checkSurvivors(){
        int n = this.getEnemies().size();
        for(int i = 0; i<n; i++){
            if (this.getEnemies().get(i).isKnockedOut()) {
                this.getCharacters().remove(this.getEnemies().get(i));
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
     * @return luigi
     */
    public Luigi getLuigi(){
        return this.luigi;
    }

    /**
     * Get marcos marcos.
     *
     * @return marcos
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
     * Is boo turn boolean. True if it's a boo's turn to play.
     *
     * @return the boolean
     */
    public boolean isBooTurn() {
        return this.state.isBooTurn();
    }

    /**
     * Is goomba turn boolean. True if it's a Gooomba's turn to play.
     *
     * @return the boolean
     */
    public boolean isGoombaTurn() {
        return this.state.isGoombaTurn();
    }

    /**
     * Is spiny turn boolean. True if it's a Spiny's turn to play.
     *
     * @return the boolean
     */
    public boolean isSpinyTurn() {
        return this.state.isSpinyTurn();
    }

    /**
     * Is player turn boolean. True if a it's a players turn to play.
     *
     * @return the boolean
     */
    public boolean isPlayerTurn() {
        return state.isPlayerTurn();
    }

    /**
     * Adds enemy to battle.
     *
     * @param anEnemy the enemy to be added.
     */
    public void addEnemy(Enemy anEnemy) {
        this.getEnemies().add(anEnemy);
        this.addCharacter(anEnemy);
    }

    /**
     * Add a player to the battle.
     *
     * @param aPlayer the player
     */
    public void addPlayer(Player aPlayer) {
        this.getPlayers().add(aPlayer);
        this.addCharacter(aPlayer);
    }

    /**
     * Adds a marcos to be the battle.
     *
     * @param aMarcos the marcos
     */
    public void addMarcos(Marcos aMarcos) {
        this.addPlayer(aMarcos);
        this.marcos = aMarcos;
    }

    /**
     * Adds a luigi to the battle.
     *
     * @param aLuigi the luigi
     */
    public void addLuigi(Luigi aLuigi) {
        this.addPlayer(aLuigi);
        this.luigi = aLuigi;
    }

    /**
     * Adds random enemy to the battle.
     *
     * @param level the level of the enemy to be added.
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

    /**
     * Gets next character to play.
     *
     * @return the next character
     */
    public Character getNextCharacter() {
        return this.NextPlayer;
    }


}


