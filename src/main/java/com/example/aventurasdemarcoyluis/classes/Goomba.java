package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.abstractclasses.AbstractCharacter;
import com.example.aventurasdemarcoyluis.abstractclasses.AbstractEnemy;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;

/**
 * The type Goomba. It's an enemy character.
 */
public class Goomba extends AbstractEnemy {
    /**
     * Instantiates a new Goomba. Base points are set to 100 arbitrarily.
     *
     * @param lvl the lvl
     */
    public Goomba(int lvl) {
        super(lvl, "Goomba", 100, 100, 100);
    }

}
