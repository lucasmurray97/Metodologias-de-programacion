package com.example.aventurasdemarcoyluis.classes;

public class Alive extends State{
    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void knockOut() {
        this.changeState(new KnockedOut());
    }

    @Override
    public void jumpAttack() {}

    @Override
    public void hammerAttack() {}

    @Override
    public void normalAttack() {}
    @Override
    public void jumpAttacked() {}

    @Override
    public void hammerAttacked() {}
}
