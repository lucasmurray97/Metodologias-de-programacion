package com.example.aventurasdemarcoyluis.model.Battle;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.BattleOverHandler;

import java.util.ArrayList;
import java.util.Random;

/**
 * The interface of a Battle.
 */
public interface IBattle {
    /**
     * Sets next character.
     *
     * @param aCharacter the character
     */
    void setNextCharacter(Character aCharacter);

    /**
     * Gets random.
     *
     * @return the random
     */
    Random getRandom();

    /**
     * Sets random.
     *
     * @param random the random
     */
    void setRandom(Random random);

    /**
     * Adds the a battle over observer.
     *
     * @param resp the resp
     */
    void addObserver(BattleOverHandler resp);

    /**
     * Sets outcome.
     *
     * @param outcome the outcome
     */
    void setOutcome(int outcome);

    /**
     * Sets state.
     *
     * @param aState the a state
     */
    void setState(BattleState aState);

    /**
     * Gets state.
     *
     * @return the state
     */
    BattleState getState();

    /**
     * Gets characters.
     *
     * @return the characters
     */
    ArrayList<Character> getCharacters();

    /**
     * Add character.
     *
     * @param aCharacter the character
     */
    void addCharacter(Character aCharacter);

    /**
     * Gets bag pack.
     *
     * @return the bag pack
     */
    BagPack getBagPack();

    /**
     * Sets bag pack.
     *
     * @param aBag the bag
     */
    void setBagPack(BagPack aBag);

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    boolean isOver();

    /**
     * Gets outcome.
     *
     * @return the outcome
     */
    int getOutcome();

    /**
     * Gets current player.
     *
     * @return the current player
     */
    Character getCurrentPlayer();

    /**
     * Sets current character.
     *
     * @param aCharacter the character
     */
    void setCurrentCharacter(Character aCharacter);

    /**
     * Chooses target for luigi to attack.
     *
     * @param enemy the enemy
     * @throws InvalidGamePlay the invalid game play exception
     */
    void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay;

    /**
     * Choose target for marcos to attack.
     *
     * @param enemy the enemy
     * @throws InvalidGamePlay the invalid game play exception
     */
    void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay;

    /**
     * Chooses item.
     *
     * @param str the str
     * @throws InvalidGamePlay the invalid game play exception
     */
    void chooseItem(String str) throws InvalidGamePlay;

    /**
     * Chooses player.
     *
     * @param aPlayer the  player to use the item
     * @throws InvalidGamePlay the invalid game play
     */
    void choosePlayer(Player aPlayer) throws InvalidGamePlay;

    /**
     * Sets seed.
     *
     * @param n the n
     */
    void setSeed(int n);

    /**
     * Gets players.
     *
     * @return the players
     */
    ArrayList<Player> getPlayers();

    /**
     * Is luigis turn boolean.
     *
     * @return the boolean
     */
    boolean isLuigisTurn();

    /**
     * Is marcos turn boolean.
     *
     * @return the boolean
     */
    boolean isMarcosTurn();

    /**
     * Terminate.
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    void terminate() throws InvalidGamePlay;

    /**
     * Is enemy turn boolean.
     *
     * @return the boolean
     */
    boolean isEnemyTurn();

    /**
     * Gets enemies.
     *
     * @return the enemies
     */
    ArrayList<Enemy> getEnemies();


    /**
     * Gets luigi.
     *
     * @return the luigi
     */
    Luigi getLuigi();

    /**
     * Gets marcos.
     *
     * @return the marcos
     */
    Marcos getMarcos();

    /**
     * Marcos jump attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    void marcosJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    /**
     * Luigi jump attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    void luigiJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    /**
     * Normal attack that enemies perform
     *
     * @throws InvalidGamePlay the invalid game play exception
     */
    void normalAttack() throws InvalidGamePlay;

    /**
     * Marcos hammer attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    void marcosHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    /**
     * Luigi hammer attack.
     *
     * @throws InvalidCharacterActionException the invalid character action exception
     * @throws InvalidGamePlay                 the invalid game play exception
     */
    void luigiHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    /**
     * Is boo turn boolean.
     *
     * @return the boolean
     */
    boolean isBooTurn();

    /**
     * Is goomba turn boolean.
     *
     * @return the boolean
     */
    boolean isGoombaTurn();

    /**
     * Is spiny turn boolean.
     *
     * @return the boolean
     */
    boolean isSpinyTurn();

    /**
     * Is player turn boolean.
     *
     * @return the boolean
     */
    boolean isPlayerTurn();

    /**
     * Add enemy.
     *
     * @param anEnemy the an enemy
     */
    void addEnemy(Enemy anEnemy);

    /**
     * Add player.
     *
     * @param aPlayer the a player
     */
    void addPlayer(Player aPlayer);

    /**
     * Add marcos.
     *
     * @param aMarcos the a marcos
     */
    void addMarcos(Marcos aMarcos);

    /**
     * Add luigi.
     *
     * @param aLuigi the a luigi
     */
    void addLuigi(Luigi aLuigi);

    /**
     * Add random enemy.
     *
     * @param level the level
     */
    void addRandomEnemy(int level);

    /**
     * Add random enemy.
     *
     * @param level the level
     * @param hp    the hp
     * @param atk   the atk
     * @param def   the def
     */
    void addRandomEnemy(int level, int hp, int atk, int def);

    /**
     * Gets next character.
     *
     * @return the next character
     */
    Character getNextCharacter();
}
