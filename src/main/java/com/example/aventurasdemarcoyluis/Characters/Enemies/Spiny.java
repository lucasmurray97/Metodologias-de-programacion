package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.EnemyTurn;
import com.example.aventurasdemarcoyluis.Game.Battle.BattleStates.SpinyTurn;

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
    public void normalAttack(AttackableBySpiny aPlayer){
        super.normalAttack(aPlayer);
    }
    @Override
    public void jumpAttacked(int damage, Player aPlayer) {
        aPlayer.setHp((int) (0.95*aPlayer.getHp()));
    }
    @Override
    public EnemyTurn myTurn(){
        return new SpinyTurn();
    }
}
