package com.example.aventurasdemarcoyluis.Characters.Players;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByBoo;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableBySpiny;

/**
 * The type Luigi. It's a protagonist character, intended to be used by the user.
 */
public class Luigi extends AbstractPlayer implements AttackableByGoomba, AttackableBySpiny, AttackableByBoo {
    /**
     * Instantiates a new Luigi. Base points are set to 100 arbitrarily. Default method for testing.
     *
     * @param lvl the level.
     */
    public Luigi(int lvl) {
        super(lvl, "Luigi", 100, 100, 100);
    }

    /**
     * Instantiates a new Luigi, base points are settable now and includes bag binding.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     * @param bag     the bag
     */
    public Luigi(int lvl, int baseHp, int baseAtk, int baseDef, BagPack bag) {
        super(lvl, "Luigi", baseHp, baseAtk, baseDef, bag);
    }

    /**
     * Instantiates a new Luigi, includes bag binding.
     *
     * @param lvl the lvl
     * @param bag the bag
     */
    public Luigi(int lvl, BagPack bag) {
        super(lvl, "Luigi", 100, 100, 100, bag);
    }

    /**
     * Hammer attack.
     *
     * @param anEnemy the an enemy
     */
    public void hammerAttack(AttackableByLuigi anEnemy){
        super.hammerAttack(anEnemy);
    }

    /**
     * Jump attack.
     *
     * @param anEnemy the an enemy
     */
    public void jumpAttack(AttackableByLuigi anEnemy){
        super.jumpAttack(anEnemy);
    }

    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
