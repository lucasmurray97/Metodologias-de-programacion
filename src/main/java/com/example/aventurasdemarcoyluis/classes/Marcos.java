package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractPlayer;
import com.example.aventurasdemarcoyluis.interfaces.*;

/**
 * The type Marcos. It's a protagonist character, intended to be used by the user.
 */
public class Marcos extends AbstractPlayer implements AttackableByGoomba, AttackableBySpiny {
    /**
     * Instantiates a new Marcos. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Marcos(int lvl) {
        super(lvl, "Marcos", 100, 100, 100);
    }

    public Marcos(int lvl, BagPack bag) {
        super(lvl, "Marcos", 100, 100, 100, bag);
    }

    public void hammerAttack(AttackableByMarcos anEnemy){
        super.hammerAttack(anEnemy);
    }

    public void jumpAttack(AttackableByMarcos anEnemy){
        super.jumpAttack(anEnemy);
    }
    @Override
    public void useItem(String anItem) {
        super.useItem(anItem);
    }
}
