package com.example.aventurasdemarcoyluis.model.Game.GameStates;

import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;

import java.util.ArrayList;

/**
 * The State InBattle. State the game switches to when a battle is taking place.
 */
public class InBattle extends GameState{
    /**
     * Battle asigned to the state.
     */
    private Battle battle;
    /**
     * Is in battle boolean. Returns True.
     *
     * @return the boolean
     */
    @Override
    public boolean isInBattle() {
        return true;
    }
    /**
     * Sets battle.
     *
     * @param battle the battle
     */
    @Override
    public void setBattle(Battle battle){
        this.battle = battle;
    }
    /**
     * Gets battle.
     *
     * @return the battle
     */
    @Override
    public Battle getBattle(){
        return this.battle;
    }
    /**
     * Chooses target marcos.
     *
     * @param enemy the enemy to be attacked
     */
    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay {
        this.battle.chooseTargetMarcos(enemy);
    }
    /**
     * Chooses target luigi.
     *
     * @param enemy the enemy to be attacked.
     */
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay {
        this.battle.chooseTargetLuigi(enemy);
    }
    /**
     * Marcos jump attack.
     */
    @Override
    public void marcosJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.marcosJumpAttack();
    }
    /**
     * Luigi jump attack.
     */
    @Override
    public void luigiJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.luigiJumpAttack();
    }
    /**
     * Marcos hammer attack.
     */
    @Override
    public void marcosHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.marcosHammerAttack();
    }
    /**
     * Luigi hammer attack.
     */
    @Override
    public void luigiHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.luigiHammerAttack();
    }
    /**
     * Normal attacked to be performed by an enemy to a random player.
     */
    @Override
    public void normalAttack() throws InvalidGamePlay {
        this.battle.getState().setEnemyTurn();
        this.battle.normalAttack();
    }
    /**
     * Chooses item to be used.
     *
     * @param str the str
     */
    @Override
    public void chooseItem(String str) throws InvalidGamePlay {
        this.battle.chooseItem(str);
    }
    /**
     * Chooses player for the chosen item to take effect on.
     *
     * @param aPlayer the player
     */
    @Override
    public void choosePlayer(Player aPlayer) throws InvalidGamePlay {
        this.battle.choosePlayer(aPlayer);
    }
    /**
     * Terminates current turn.
     */
    @Override
    public void terminate() throws InvalidGamePlay {
        this.battle.terminate();
    }
    /**
     * Gets characters.
     *
     * @return the characters
     */
    @Override
    public ArrayList<Character> getCharacters(){
        return this.battle.getCharacters();
    }
    /**
     * Gets current player.
     *
     * @return the current player
     */
    @Override
    public Character getCurrentPlayer() {
        return battle.getCurrentPlayer();
    }
    /**
     * Gets next character.
     *
     * @return the next character
     */
    @Override
    public Character getNextCharacter() {
        return battle.getNextCharacter();
    }
    /**
     * Adds random enemy.
     *
     * @param level the level of the enemies to be added.
     */
    @Override
    public void addRandomEnemy(int level){
        this.battle.addRandomEnemy(level);
    }

    public void onBattleOver(int newValue) {
        if(newValue==1){
            this.getGame().setState(new PreparingBattle());
            try {
                this.getGame().getState().increaseScore();
            } catch (InvalidGamePlay e) {
                e.printStackTrace();
            }
        }else if(newValue==-1){
            this.getGame().setState(new GameOver());
        }
    }
}
