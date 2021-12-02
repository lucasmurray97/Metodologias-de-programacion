package com.example.aventurasdemarcoyluis.Characters.States;

/**
 * Character State when knock out. In general blocks usability of methods by the characters since it's
 * knocked out. Also prevents certain methods to be applied to the character.
 */
public class KnockedOut extends CharacterState {
    /**
     * Returns True
     * @return
     */
    @Override
    public boolean isKnockedOut() {
        return true;
    }

}
