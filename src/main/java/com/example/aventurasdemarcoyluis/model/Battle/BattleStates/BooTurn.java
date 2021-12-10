package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;

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
    public void normalAttack() throws InvalidGamePlay {
        this.setCurrentCharacter((Boo) this.getCurrentCharacter());
        if(this.isLuigiAlive()){
            ((Boo) this.getCurrentCharacter()).normalAttack(this.getBattle().getLuigi());
        }
        terminate();
    }
}
