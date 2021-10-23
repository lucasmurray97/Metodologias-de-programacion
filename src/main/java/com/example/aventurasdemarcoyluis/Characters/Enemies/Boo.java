package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.BooTurn;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

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
     * Normal attack.
     *
     * @param aPlayer the a player
     */
    public void normalAttack(AttackableByBoo aPlayer){
        super.normalAttack(aPlayer);
    }

    /**
     *Boo dodges hammer attacks, therefore no damage is done
     * @param damage
     * @param aPlayer
     */
    @Override
    public void hammerAttacked(int damage, Player aPlayer) {
    }
    @Override
    public EnemyTurn myTurn(){
        return new BooTurn();
    }
}
