package com.example.aventurasdemarcoyluis.Characters.Enemies;

import com.example.aventurasdemarcoyluis.Characters.AbstractCharacter;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

/**
 * The type Abstract enemy.
 */
public abstract class AbstractEnemy extends AbstractCharacter implements Enemy {
    /**
     * Instantiates a new Abstract character.
     *
     * @param lvl      the level
     * @param type     the type
     * @param aBaseHp  the base hp defined for each specific character
     * @param aBaseAtk the a base atk defined for each specific character
     * @param aBaseDef the a base def defined for each specific character
     */
    public AbstractEnemy(int lvl, String type, int aBaseHp, int aBaseAtk, int aBaseDef) {
        super(lvl, type, aBaseHp, aBaseAtk, aBaseDef);
    }

    /**
     * Normal attack.
     *
     * @param aPlayer the a player
     */
    protected void normalAttack(Player aPlayer){
        this.getState().normalAttack();
        int damage = (int) Math.round(0.75 * this.getAtk() * (this.getLvl() / (double) aPlayer.getDef()));
        aPlayer.normalAttacked(damage, this);
    };

    @Override
    public void hammerAttacked(int damage, Player aPlayer) {
        this.getState().hammerAttacked();
        this.setHp(this.getHp()-damage);
    }

    @Override
    public void jumpAttacked(int damage, Player aPlayer) {
        this.getState().jumpAttacked();
        this.setHp(this.getHp()-damage);
    }
}
