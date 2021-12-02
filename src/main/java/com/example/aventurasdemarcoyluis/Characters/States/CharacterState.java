package com.example.aventurasdemarcoyluis.Characters.States;

import com.example.aventurasdemarcoyluis.Characters.Character;

/**
 * Generic State for a character. In general
 */
public class CharacterState {
    /**
     * The Character.
     */
    Character character;

    /**
     * Gets character.
     *
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Sets character.
     *
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Changes state.
     *
     * @param characterState the state
     */
    protected void changeState(CharacterState characterState) {
        character.setState(characterState);
    }

    /**
     * Is knocked out boolean. True if knocked out.
     *
     * @return the boolean
     */
    public boolean isKnockedOut() {
        return false;
    }

    /**
     * Is alive boolean. True if alive.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return false;
    }

    /**
     * Error. Throws assertion error with message "Wrong State".
     */
    public void error() {
        throw new AssertionError("Wrong state");
    }

    /**
     * Knocks out a character.
     */
    public void knockOut(){
        error();
    }

    /**
     * Revives a character, resetting it's stats.
     */
    public void revive() {
        this.changeState(new Alive());
        this.getCharacter().setHp(this.getCharacter().getMaxHp());
        this.getCharacter().setAtk(this.getCharacter().getMaxAtk());
    }

    /**
     * Jump attack.
     */
    public void jumpAttack(){
        error();
    }

    /**
     * Hammer attack.
     */
    public void hammerAttack(){
        error();
    }

    /**
     * Normal attacked. To be run when platyer is attacked.
     */
    public void normalAttacked(){
        error();
    }

    /**
     * Normal attack, for enemies.
     */
    public void normalAttack(){
        error();
    }

    /**
     * Jump attacked, when an enemy is attacked.
     */
    public void jumpAttacked(){
        error();
    }

    /**
     * Hammer attacked, when enemy is attacked.
     */
    public void hammerAttacked(){
        error();
    }
}
