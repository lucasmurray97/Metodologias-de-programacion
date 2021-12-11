package com.example.aventurasdemarcoyluis.model.Characters;

import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Characters.States.CharacterState;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.KnockedOutHandler;

/**
 * The type Null character, all methods are empty, return null or false.
 */
public class NullCharacter implements Character{
    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setState(CharacterState characterState) {

    }

    @Override
    public void setHp(int i) {

    }

    @Override
    public void setAtk(int i) {

    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public int getMaxAtk() {
        return 0;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean isKnockedOut() {
        return false;
    }

    @Override
    public int getAtk() {
        return 0;
    }

    @Override
    public int getLvl() {
        return 0;
    }

    @Override
    public void onDeath(Battle battle, int newValue) {

    }

    @Override
    public void addObserver(KnockedOutHandler resp) {

    }
}
