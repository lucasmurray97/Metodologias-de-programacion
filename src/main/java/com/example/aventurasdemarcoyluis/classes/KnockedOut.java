package com.example.aventurasdemarcoyluis.classes;

public class KnockedOut extends State{
    @Override
    public boolean isKnockedOut() {
        return true;
    }

    @Override
    public void revive() {
        this.changeState(new Alive());
        this.getCharacter().setHp(this.getCharacter().getMaxHp());
        this.getCharacter().setAtk(this.getCharacter().getMaxAtk());
    }
}
