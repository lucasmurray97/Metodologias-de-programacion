package com.example.aventurasdemarcoyluis.Characters.States;

import com.example.aventurasdemarcoyluis.Characters.Character;

/**
 * The type State.
 */
public class State {
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
     * Change state.
     *
     * @param state the state
     */
    protected void changeState(State state) {
        character.setState(state);
    }

    /**
     * Is knocked out boolean.
     *
     * @return the boolean
     */
    public boolean isKnockedOut() {
        return false;
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return false;
    }

    /**
     * Error.
     */
    void error() {
        throw new AssertionError("Wrong state");
    }

    /**
     * Knock out.
     */
    public void knockOut(){
        error();
    }

    /**
     * Revive.
     */
    public void revive(){
        error();
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
     * Normal attacked.
     */
    public void normalAttacked(){
        error();
    }

    /**
     * Normal attack.
     */
    public void normalAttack(){
        error();
    }

    /**
     * Jump attacked.
     */
    public void jumpAttacked(){
        error();
    }

    /**
     * Hammer attacked.
     */
    public void hammerAttacked(){
        error();
    }
}
