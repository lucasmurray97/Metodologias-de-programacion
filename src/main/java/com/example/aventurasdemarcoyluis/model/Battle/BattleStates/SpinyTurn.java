package com.example.aventurasdemarcoyluis.model.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;

/**
 * * State when a Spiny is playing.
 */
public class SpinyTurn extends EnemyTurn{
    /**
     * Returns True
     * @return
     */
    @Override
    public boolean isSpinyTurn(){
        return true;
    }
    /**
     * Attacks an enemy attackable by spiny.
     */
    @Override
    public void normalAttack() throws InvalidGamePlay {
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Spiny) this.getCurrentCharacter()).normalAttack((AttackableBySpiny) toBeattacked);
        terminate();
    }
}
