package com.example.aventurasdemarcoyluis.model.Characters.Enemies;

import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.SpinyTurn;

/**
 * The type Spiny. It's an enemy character.
 */
public class Spiny extends AbstractEnemy implements AttackableByLuigi, AttackableByMarcos {
    /**
     * Instantiates a new Spiny. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level.
     */
    public Spiny(int lvl) {
        super(lvl, "Spiny", 100, 100, 100);
    }

    /**
     * Instantiates a new Spiny, base points are settable now. Default method for testing.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     */
    public Spiny(int lvl, int baseHp, int baseAtk, int baseDef) {
        super(lvl, "Spiny", baseHp, baseAtk, baseDef);
    }

    /**
     * Normal attack.
     *
     * @param aPlayer the a player
     */
    public void normalAttack(AttackableBySpiny aPlayer){
        super.normalAttack(aPlayer);
    }

    /**
     * If jump attacked, attacker takes 5% damage.
     * @param damage  the damage
     * @param aPlayer the player
     */
    @Override
    public void jumpAttacked(int damage, Player aPlayer) {
        aPlayer.setHp((int) (0.95*aPlayer.getHp()));
    }
    /**
     * Returns Spiny Turn.
     * @return
     */
    @Override
    public EnemyTurn myTurn(){
        return new SpinyTurn();
    }
}
