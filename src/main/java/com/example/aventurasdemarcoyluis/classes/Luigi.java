package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractPlayer;
import com.example.aventurasdemarcoyluis.interfaces.*;

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

    public void hammerAttack(AttackableByLuigi anEnemy){
        super.hammerAttack(anEnemy);
    }
    public void hammerAttack(AttackableByLuigi anEnemy, String test){
        super.hammerAttack(anEnemy, test);
    }
    public void jumpAttack(AttackableByLuigi anEnemy){
        super.jumpAttack(anEnemy);
    };
}
