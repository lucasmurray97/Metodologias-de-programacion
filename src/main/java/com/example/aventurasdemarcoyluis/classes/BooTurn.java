package com.example.aventurasdemarcoyluis.classes;

public class BooTurn extends EnemyTurn{
    @Override
    public boolean isBooTurn(){
        return true;
    }
    @Override
    public void normalAttack(){
        this.setCurrentCharacter((Boo) this.getCurrentCharacter());
        if(this.isLuigiAlive()){
            ((Boo) this.getCurrentCharacter()).normalAttack(this.getBattle().getLuigi());
        }
        pass();
    }
}
