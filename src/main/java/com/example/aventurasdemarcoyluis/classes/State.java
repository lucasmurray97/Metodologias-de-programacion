package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.Character;

public class State {
    Character character;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    protected void changeState(State state) {
        character.setState(state);
    }

    public boolean isKnockedOut() {
        return false;
    }
    public boolean isAlive() {
        return false;
    }
    void error() {
        throw new AssertionError("Wrong state");
    }

    public void knockOut(){
        error();
    }
    public void revive(){
        error();
    }
    public void jumpAttack(){
        error();
    }
    public void hammerAttack(){
        error();
    }
    public void normalAttack(){
        error();
    }
    public void jumpAttacked(){
        error();
    }
    public void hammerAttacked(){
        error();
    }
}
