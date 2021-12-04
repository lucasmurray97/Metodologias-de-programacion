package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;

/**
 * State when a Boo is playing.
 */
public class BooTurn extends EnemyTurn{
    /**
     * Returns True.
     * @return
     */
    @Override
    public boolean isBooTurn(){
        return true;
    }

    /**
     * Attacks luigi if alive.
     */
    @Override
    public void normalAttack(){
        this.setCurrentCharacter((Boo) this.getCurrentCharacter());
        if(this.isLuigiAlive()){
            ((Boo) this.getCurrentCharacter()).normalAttack(this.getBattle().getLuigi());
        }
        terminate();
    }
}
