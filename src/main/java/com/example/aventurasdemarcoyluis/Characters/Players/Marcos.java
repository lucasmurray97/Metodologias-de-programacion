package com.example.aventurasdemarcoyluis.Characters.Players;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableBySpiny;

/**
 * The type Marcos. It's a protagonist character, intended to be used by the user.
 */
public class Marcos extends AbstractPlayer implements AttackableByGoomba, AttackableBySpiny {
    /**
     * Instantiates a new Marcos. Base points are set to 100 arbitrarily. Default method for testing.
     *
     * @param lvl the lvl
     */
    public Marcos(int lvl) {
        super(lvl, "Marcos", 100, 100, 100);
    }

    /**
     * Instantiates a new Marcos, base points are settable now and includes bag binding.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     * @param bag     the bag
     */
    public Marcos(int lvl, int baseHp, int baseAtk, int baseDef, BagPack bag) {
        super(lvl, "Marcos", baseHp, baseAtk, baseDef, bag);
    }

    /**
     * Instantiates a new Marcos, includes bag binding.
     *
     * @param lvl the lvl
     * @param bag the bag
     */
    public Marcos(int lvl, BagPack bag) {
        super(lvl, "Marcos", 100, 100, 100, bag);
    }

    /**
     * Hammer attack.
     *
     * @param anEnemy the an enemy
     */
    public void hammerAttack(AttackableByMarcos anEnemy){
        super.hammerAttack(anEnemy);
    }

    /**
     * Jump attack.
     *
     * @param anEnemy the an enemy
     */
    public void jumpAttack(AttackableByMarcos anEnemy){
        super.jumpAttack(anEnemy);
    }
    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
