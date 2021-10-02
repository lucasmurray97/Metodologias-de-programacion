package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractCharacter;
import com.example.aventurasdemarcoyluis.abstractclasses.AbstractEnemy;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;
import com.example.aventurasdemarcoyluis.interfaces.Player;

/**
 * The type Boo. It's an enemy character.
 */
public class Boo extends AbstractEnemy{
    /**
     * Instantiates a new Boo. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level
     */
    public Boo(int lvl) {
        super(lvl, "Boo", 100, 100, 100);
    }

    @Override
    public void hammerAttacked(int damage, Player aPlayer) {
    }

    @Override
    public void jumpAttacked(int damage, Player aPlayer) {
        if(aPlayer.getType() != "Luigi"){
            super.jumpAttacked(damage,aPlayer);
        }
    }

}
