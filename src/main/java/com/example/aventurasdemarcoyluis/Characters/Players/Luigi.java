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
     * Instantiates a new Luigi. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level.
     */
    public Luigi(int lvl) {
        super(lvl, "Luigi", 100, 100, 100);
    }

    public Luigi(int lvl, BagPack bag) {
        super(lvl, "Luigi", 100, 100, 100, bag);
    }

    public void hammerAttack(AttackableByLuigi anEnemy){
        super.hammerAttack(anEnemy);
    }

    public void jumpAttack(AttackableByLuigi anEnemy){
        super.jumpAttack(anEnemy);
    }

    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
