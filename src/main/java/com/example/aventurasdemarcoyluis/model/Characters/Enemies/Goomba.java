package com.example.aventurasdemarcoyluis.model.Characters.Enemies;

import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.GoombaTurn;

/**
 * The type Goomba. It's an enemy character.
 */
public class Goomba extends AbstractEnemy implements AttackableByLuigi, AttackableByMarcos {
    /**
     * Instantiates a new Goomba. Base points are set to 100 arbitrarily. Default method for testing.
     *
     * @param lvl the lvl
     */
    public Goomba(int lvl) {
        super(lvl, "Goomba", 100, 100, 100);
    }

    /**
     * Instantiates a new Goomba.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     */
    public Goomba(int lvl, int baseHp, int baseAtk, int baseDef) {
        super(lvl, "Goomba", baseHp, baseAtk, baseDef);
    }

    /**
     * Normal attack.
     *
     * @param aPlayer the a player
     */
    public void normalAttack(AttackableByGoomba aPlayer){
        super.normalAttack(aPlayer);
    }
    /**
     * Returns Goomba Turn.
     * @return
     */
    @Override
    public EnemyTurn myTurn(){
        return new GoombaTurn();
    }
}
