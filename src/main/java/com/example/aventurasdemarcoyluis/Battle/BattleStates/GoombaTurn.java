package com.example.aventurasdemarcoyluis.Battle.BattleStates;

import com.example.aventurasdemarcoyluis.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * State when a Goomba is playing.
 */
public class GoombaTurn extends EnemyTurn{
    /**
     * Returns True.
     * @return
     */
    @Override
    public boolean isGoombaTurn(){
        return true;
    }

    /**
     * Attacks an enemy attackable by goomba.
     */
    @Override
    public void normalAttack(){
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Goomba) this.getCurrentCharacter()).normalAttack((AttackableByGoomba) toBeattacked);
        terminate();
    }
}
