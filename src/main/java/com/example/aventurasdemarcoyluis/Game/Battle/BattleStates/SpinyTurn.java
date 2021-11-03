package com.example.aventurasdemarcoyluis.Game.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * The type Spiny turn.
 */
public class SpinyTurn extends EnemyTurn{
    @Override
    public boolean isSpinyTurn(){
        return true;
    }
    @Override
    public void normalAttack(){
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Spiny) this.getCurrentCharacter()).normalAttack((AttackableBySpiny) toBeattacked);
        terminate();
    }
}
