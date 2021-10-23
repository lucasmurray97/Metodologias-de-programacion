package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.GoombaTurn;

/**
 * The type Goomba. It's an enemy character.
 */
public class Goomba extends AbstractEnemy implements AttackableByLuigi, AttackableByMarcos {
    /**
     * Instantiates a new Goomba. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Goomba(int lvl) {
        super(lvl, "Goomba", 100, 100, 100);
    }

    public void normalAttack(AttackableByGoomba aPlayer){
        super.normalAttack(aPlayer);
    }
    @Override
    public EnemyTurn myTurn(){
        return new GoombaTurn();
    }
}
