package com.example.aventurasdemarcoyluis.model.Characters.Enemies;

import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BooTurn;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;

/**
 * The type Boo. It's an enemy character.
 */
public class Boo extends AbstractEnemy implements AttackableByMarcos {
    /**
     * Instantiates a new Boo. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level
     */
    public Boo(int lvl) {
        super(lvl, "Boo", 100, 100, 100);
    }


    /**
     * Instantiates a new Boo, base points are settable now. Default method for testing.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     */
    public Boo(int lvl, int baseHp, int baseAtk, int baseDef) {
        super(lvl, "Boo", baseHp, baseAtk, baseDef);
    }

    /**
     * Normal attack.
     *
     * @param aPlayer the a player
     */
    public void normalAttack(AttackableByBoo aPlayer){
        super.normalAttack(aPlayer);
    }

    /**
     *Boo dodges hammer attacks, therefore no damage is done.
     * @param damage
     * @param aPlayer
     */
    @Override
    public void hammerAttacked(int damage, Player aPlayer) {
    }

    /**
     * Returns Boo Turn.
     * @return
     */
    @Override
    public EnemyTurn myTurn(){
        return new BooTurn();
    }
}
