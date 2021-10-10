package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractEnemy;
import com.example.aventurasdemarcoyluis.interfaces.AttackableByBoo;
import com.example.aventurasdemarcoyluis.interfaces.AttackableByMarcos;

/**
 * The type Boo. It's an enemy character.
 */
public class Boo extends AbstractEnemy implements AttackableByMarcos {
    /**
     * Instantiates a new Boo. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level
     */
    public Boo(int lvl) {
        super(lvl, "Boo", 100, 100, 100);
    }

    public void normalAttack(AttackableByBoo aPlayer){
        super.normalAttack(aPlayer);
    }
}
