package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractPlayer;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;

/**
 * The type Marcos. It's a protagonist character, intended to be used by the user.
 */
public class Marcos extends AbstractPlayer {
    /**
     * Instantiates a new Marcos. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Marcos(int lvl) {
        super(lvl, "Marcos", 100, 100, 100);
    }

    @Override
    public void normalAttacked(int damage, Enemy anEnemy){
        if (anEnemy.getType() != "Boo") {
            this.setHp(this.getHp() - damage);
        }
    };
}
