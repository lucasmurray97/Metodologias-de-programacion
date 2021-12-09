package com.example.aventurasdemarcoyluis.model.Game.GameStates;

import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.Game;

import java.util.ArrayList;

/**
 * Generic Game state.
 */
public class GameState {
    private Game game;

    /**
     * Gets the game.
     *
     * @return the game
     */
    public Game getGame(){
        return this.game;
    }

    /**
     * Is preparing battle boolean. True if Game in state PreparingBattle.
     *
     * @return the boolean
     */
    public boolean isPreparingBattle() {
        return false;
    }

    /**
     * Is in battle boolean. True if Game in state InBattle.
     *
     * @return the boolean
     */
    public boolean isInBattle() {
        return false;
    }

    /**
     * Lost boolean. Returns true if players lost game.
     *
     * @return the boolean
     */
    public boolean Lost() {
        return false;
    }

    /**
     * Has won boolean. Returns True if players won game.
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
     * Error. Throws an assertion error with the message "Wrong State"
     */

    /**
     * Creates battle.
     *
     * @param i is the number of random enemies to be added.
     */
    public void createBattle(int i) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot create a battle now!");
    }

    /**
     * Creates empty battle.
     */
    public void createBattle() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot create a battle now!");
    }

    /**
     * Adds random enemy.
     *
     * @param level the level of the enemies to be added.
     */
    public void addRandomEnemy(int level) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot add an enemy now!");
    }

    /**
     * Add honey syrup.
     *
     * @param i the quantity of the item to be added.
     */
    public void addHoneySyrup(int i) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot add an item now!");
    }

    /**
     * Add red mushroom.
     *
     * @param i the quantity of the item to be added.
     */
    public void addRedMushroom(int i) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot add an item now!");
    }

    /**
     * Sets battle.
     *
     * @param battle the battle
     */
    public void setBattle(Battle battle) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot set the battle state now!");
    }

    /**
     * Gets battle.
     *
     * @return the battle
     */
    public Battle getBattle() throws InvalidGamePlay {
        throw new InvalidGamePlay("There is no battle taking place!");
    }

    /**
     * Chooses target marcos.
     *
     * @param enemy the enemy to be attacked
     */
    public void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot choose a target now!");
    }

    /**
     * Marcos jump attack.
     */
    public void marcosJumpAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        throw new InvalidGamePlay("You cannot jump attack now!");
    }

    /**
     * Normal attacked to be performed by an enemy to a random player.
     */
    public void normalAttack() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot normal attack now!");
    }

    /**
     * Chooses target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    public void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot choose a target now!");
    }

    /**
     * Luigi jump attack.
     */
    public void luigiJumpAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        throw new InvalidGamePlay("You cannot jump attack now!");
    }

    /**
     * Chooses item to be used.
     *
     * @param str the str
     */
    public void chooseItem(String str) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot choose an item now!");
    }

    /**
     * Chooses player for the chosen item to take effect on.
     *
     * @param aPlayer the player
     */
    public void choosePlayer(Player aPlayer) throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot choose a player now!");
    }

    /**
     * Terminates current turn if in battle.
     */
    public void terminate() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot terminate the turn now!");
    }

    /**
     * Level up. Increases player's level.
     */
    public void levelUp() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot increase the players levels now!");
    }

    /**
     * Gets characters.
     *
     * @return the characters
     */
    public ArrayList<Character> getCharacters() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot get characters now!");
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public Character getCurrentPlayer() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot get current player now!");
    }

    /**
     * Gets next character.
     *
     * @return the next character
     */
    public Character getNextCharacter() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot get next player now!");
    }


    /**
     * Increase score.
     */
    public void increaseScore() throws InvalidGamePlay {
        throw new InvalidGamePlay("You cannot increase score now!");
    }

    /**
     * Marcos hammer attack.
     */
    public void marcosHammerAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        throw new InvalidGamePlay("You cannot hammer attack now!");
    }

    /**
     * Luigi hammer attack.
     */
    public void luigiHammerAttack() throws InvalidGamePlay, InvalidCharacterActionException {
        throw new InvalidGamePlay("You cannot hammer attack now!");
    }
}
