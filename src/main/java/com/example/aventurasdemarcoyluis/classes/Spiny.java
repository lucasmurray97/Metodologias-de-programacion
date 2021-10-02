package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractEnemy;
import com.example.aventurasdemarcoyluis.interfaces.Player;

/**
 * The type Spiny. It's an enemy character.
 */
public class Spiny extends AbstractEnemy{
    /**
     * Instantiates a new Spiny. Base points are set to 100 arbitrarily.
     *
     * @param lvl the level.
     */
    public Spiny(int lvl) {
        super(lvl, "Spiny", 100, 100, 100);
    }

    @Override
    public void jumpAttacked(int damage, Player aPlayer) {
        super.jumpAttacked(damage, aPlayer);
        aPlayer.setHp((int) (0.95*aPlayer.getHp()));
    }
}
