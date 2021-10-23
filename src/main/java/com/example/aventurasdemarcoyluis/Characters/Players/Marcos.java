package com.example.aventurasdemarcoyluis.Characters.Players;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.Characters.Enemies.AttackableBySpiny;

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
