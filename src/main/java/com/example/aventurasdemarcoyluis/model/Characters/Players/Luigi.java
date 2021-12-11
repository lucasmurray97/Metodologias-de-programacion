package com.example.aventurasdemarcoyluis.model.Characters.Players;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableByBoo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;

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
        super(lvl, "Luigi", 100, 100, 100, 0);
    }

    /**
     * Instantiates a new Luigi.
     *
     * @param lvl     the lvl
     * @param baseHp  the base hp
     * @param baseAtk the base atk
     * @param baseDef the base def
     * @param baseFp  the base fp
     */
    public Luigi(int lvl, int baseHp, int baseAtk, int baseDef, int baseFp) {
        super(lvl, "Luigi", baseHp, baseAtk, baseDef, baseFp);
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
     * @throws InvalidCharacterActionException the invalid character action exception
     */
    public void hammerAttack(AttackableByLuigi anEnemy) throws InvalidCharacterActionException {
        super.hammerAttack(anEnemy);
    }

    /**
     * Jump attack.
     *
     * @param anEnemy the an enemy
     * @throws InvalidCharacterActionException the invalid character action exception
     */
    public void jumpAttack(AttackableByLuigi anEnemy) throws InvalidCharacterActionException {
        super.jumpAttack(anEnemy);
    }



    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
