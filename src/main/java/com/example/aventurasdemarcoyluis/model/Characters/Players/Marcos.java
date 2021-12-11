package com.example.aventurasdemarcoyluis.model.Characters.Players;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;

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
        super(lvl, "Marcos", 100, 100, 100, 0);
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
     * Instantiates a new Marcos.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     * @param baseFp  the base fp
     */
    public Marcos(int lvl, int baseHp, int baseAtk, int baseDef, int baseFp) {
        super(lvl, "Marcos", baseHp, baseAtk, baseDef, baseFp);
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
     * @throws InvalidCharacterActionException the invalid character action exception
     */
    public void hammerAttack(AttackableByMarcos anEnemy) throws InvalidCharacterActionException {
        super.hammerAttack(anEnemy);
    }

    /**
     * Jump attack.
     *
     * @param anEnemy the an enemy
     * @throws InvalidCharacterActionException the invalid character action exception
     */
    public void jumpAttack(AttackableByMarcos anEnemy) throws InvalidCharacterActionException {
        super.jumpAttack(anEnemy);
    }
    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
