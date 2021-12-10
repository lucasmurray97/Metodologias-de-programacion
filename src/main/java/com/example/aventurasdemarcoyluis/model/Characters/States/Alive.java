package com.example.aventurasdemarcoyluis.model.Characters.States;

/**
 * State of a character when alive.
 */
public class Alive extends CharacterState {
    /**
     * Returns true
     * @return
     */
    @Override
    public boolean isAlive() {
        return true;
    }

    /**
     * Knocks out character.
     */
    @Override
    public void knockOut() {
        this.changeState(new KnockedOut());
    }

    /**
     * The following methods are empty, nevertheless they control the flow in each of the implementations of the methods in abstract player
     * and abstract enemy, so they can only be used if the character is alive.
     */

    /**
     * Jump Attack, called in abstract player, and overrides the method in state that
     * throws an assertion error. Used to control the usability of jump attack.
     */
    @Override
    public void jumpAttack() {}

    /**
     * Hammer Attack, called in abstract player, and overrides the method in state that
     * throws an assertion error. Used to control the usability of Hammer attack.
     */
    @Override
    public void hammerAttack() {}
    /**
     * Normal Attack, called in abstract enemy, and overrides the method in state that
     * throws an assertion error. Used to control the usability of normal attack.
     */
    @Override
    public void normalAttack() {}
    /**
     * Jump Attacked, called in abstract enemy, and overrides the method in state that
     * throws an assertion error. Used to control the usability of jump attacked.
     */
    @Override
    public void jumpAttacked() {}
    /**
     * Hammer Attacked, called in abstract enemy, and overrides the method in state that
     * throws an assertion error. Used to control the usability of Hammer attacked.
     */
    @Override
    public void hammerAttacked() {}
    /**
     * Normal Attacked, called in abstract player, and overrides the method in state that
     * throws an assertion error. Used to control the usability of Normal Attacked.
     */
    @Override
    public void normalAttacked() {}
}
