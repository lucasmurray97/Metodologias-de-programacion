package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * The type Goomba turn.
 */
public class GoombaTurn extends EnemyTurn{
    @Override
    public boolean isGoombaTurn(){
        return true;
    }
    @Override
    public void normalAttack(){
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Goomba) this.getCurrentCharacter()).normalAttack((AttackableByGoomba) toBeattacked);
        terminate();
    }
}
