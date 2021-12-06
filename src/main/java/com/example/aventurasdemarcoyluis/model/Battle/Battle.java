package com.example.aventurasdemarcoyluis.model.Battle;

import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.MarcosTurn;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.BattleOverHandler;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Battle.
 */
public class Battle implements IBattle {
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
    @Override
    public void setNextCharacter(Character aCharacter) {
        this.NextPlayer = aCharacter;
    }


    /**
     * Gets random.
     *
     * @return the random
     */
    @Override
    public Random getRandom() {
        return random;
    }

    /**
     * Sets random.
     *
     * @param random the random
     */
    @Override
    public void setRandom(Random random) {
        this.random = random;
    }


    @Override
    public void addObserver(BattleOverHandler resp){
        atBattleOver.addPropertyChangeListener(resp);
    }

    /**
     * Sets outcome. 1 if players won, -1 if they lost, 0 when the battle starts.
     *
     * @param outcome the outcome
     */
    @Override
    public void setOutcome(int outcome) {
        this.outcome = outcome;
        atBattleOver.firePropertyChange("BATTLE_IS_OVER", 0,outcome);
    }

    /**
     * Sets state.
     *
     * @param aState the state
     */
    @Override
    public void setState(BattleState aState) {
        this.state = aState;
        this.state.setBattle(this);
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    @Override
    public BattleState getState() {
        return this.state;
    }

    /**
     * Gets characters.
     *
     * @return the characters
     */
    @Override
    public ArrayList<Character> getCharacters() {
        return this.characters;
    }

    /**
     * Adds a character to the battle.
     *
     * @param aCharacter the character
     */
    @Override
    public void addCharacter(Character aCharacter){
        characters.add(aCharacter);
    }

    /**
     * Gets bag pack.
     *
     * @return the bag pack
     */
    @Override
    public BagPack getBagPack() {
        return this.bag;
    }

    /**
     * Sets bag pack.
     *
     * @param aBag the a bag
     */
    @Override
    public void setBagPack(BagPack aBag) {
        this.bag = aBag;
    }


    /**
     * Is over boolean. True if battle is over.
     *
     * @return the boolean
     */
    @Override
    public boolean isOver() {
        return this.state.isOver();
    }

    /**
     * Gets outcome.
     *
     * @return the outcome
     */
    @Override
    public int getOutcome() {
        return this.outcome;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    @Override
    public Character getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Sets current character.
     *
     * @param aCharacter the a character
     */
    @Override
    public void setCurrentCharacter(Character aCharacter) {
        this.currentPlayer = aCharacter ;
        this.state.setCurrentCharacter(aCharacter);
    }


    /**
     * Choose target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.state.chooseTargetLuigi(enemy);
    }

    /**
     * Choose target marcos.
     *
     * @param enemy the enemy to be attacked.
     */
    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
    }

    /**
     * Chooses an item.
     *
     * @param str the item
     */
    @Override
    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }

    /**
     * Choose a player for the item to take effect.
     *
     * @param aPlayer the player
     */
    @Override
    public void choosePlayer(Player aPlayer) {
        this.state.choosePlayer(aPlayer);
    }

    /**
     * Sets seed.
     *
     * @param n the n
     */
    @Override
    public void setSeed(int n) {
        this.random.setSeed(n);
    }

    /**
     * Gets players currently fighting.
     *
     * @return the players
     */
    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Is luigis turn boolean. True if it's luigi's turn to play.
     *
     * @return the boolean
     */
    @Override
    public boolean isLuigisTurn() {
        return this.state.isLuigisTurn();
    }

    /**
     * Is marcos turn boolean. True if it's Marcos' turn to play
     *
     * @return the boolean
     */
    @Override
    public boolean isMarcosTurn() {
        return this.state.isMarcosTurn();
    }

    /**
     * Terinates current turn.
     */
    @Override
    public void terminate() {
        this.state.terminate();
    }

    /**
     * Is enemy turn boolean. True if an Enemy is playing.
     *
     * @return the boolean
     */
    @Override
    public boolean isEnemyTurn() {
        return this.state.isEnemyTurn();
    }

    /**
     * Gets enemies.
     *
     * @return the enemies
     */
    @Override
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    /**
     * Check survivors. Updates characters, enemies and players currently in battle, removing knocked out ones.
     */
    @Override
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
    @Override
    public Luigi getLuigi(){
        return this.luigi;
    }

    /**
     * Get marcos marcos.
     *
     * @return marcos
     */
    @Override
    public Marcos getMarcos(){
        return this.marcos;
    }

    /**
     * Marcos jump attack.
     */
    @Override
    public void marcosJumpAttack() throws InvalidCharacterActionException {
        this.state.marcosJumpAttack();
    }

    /**
     * Luigi jump attack.
     */
    @Override
    public void luigiJumpAttack() throws InvalidCharacterActionException {
        this.state.luigiJumpAttack();
    }

    /**
     * Normal attack.
     */
    @Override
    public void normalAttack() {
        this.state.normalAttack();
    }

    /**
     * Marcos hammer attack.
     */
    @Override
    public void marcosHammerAttack() throws InvalidCharacterActionException {
        this.state.marcosHammerAttack();
    }

    /**
     * Luigi hammer attack.
     */
    @Override
    public void luigiHammerAttack() throws InvalidCharacterActionException {
        this.state.luigiHammerAttack();
    }

    /**
     * Is boo turn boolean. True if it's a boo's turn to play.
     *
     * @return the boolean
     */
    @Override
    public boolean isBooTurn() {
        return this.state.isBooTurn();
    }

    /**
     * Is goomba turn boolean. True if it's a Gooomba's turn to play.
     *
     * @return the boolean
     */
    @Override
    public boolean isGoombaTurn() {
        return this.state.isGoombaTurn();
    }

    /**
     * Is spiny turn boolean. True if it's a Spiny's turn to play.
     *
     * @return the boolean
     */
    @Override
    public boolean isSpinyTurn() {
        return this.state.isSpinyTurn();
    }

    /**
     * Is player turn boolean. True if a it's a players turn to play.
     *
     * @return the boolean
     */
    @Override
    public boolean isPlayerTurn() {
        return state.isPlayerTurn();
    }

    /**
     * Adds enemy to battle.
     *
     * @param anEnemy the enemy to be added.
     */
    @Override
    public void addEnemy(Enemy anEnemy) {
        this.getEnemies().add(anEnemy);
        this.addCharacter(anEnemy);
    }

    /**
     * Add a player to the battle.
     *
     * @param aPlayer the player
     */
    @Override
    public void addPlayer(Player aPlayer) {
        this.getPlayers().add(aPlayer);
        this.addCharacter(aPlayer);
    }

    /**
     * Adds a marcos to be the battle.
     *
     * @param aMarcos the marcos
     */
    @Override
    public void addMarcos(Marcos aMarcos) {
        this.addPlayer(aMarcos);
        this.marcos = aMarcos;
    }

    /**
     * Adds a luigi to the battle.
     *
     * @param aLuigi the luigi
     */
    @Override
    public void addLuigi(Luigi aLuigi) {
        this.addPlayer(aLuigi);
        this.luigi = aLuigi;
    }

    /**
     * Adds random enemy to the battle.
     *
     * @param level the level of the enemy to be added.
     */
    @Override
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
    @Override
    public Character getNextCharacter() {
        return this.NextPlayer;
    }


}


