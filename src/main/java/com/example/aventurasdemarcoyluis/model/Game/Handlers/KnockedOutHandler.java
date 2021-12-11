package com.example.aventurasdemarcoyluis.model.Game.Handlers;

import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Game.GameStates.InBattle;

import java.beans.PropertyChangeEvent;

/**
 * The type Knocked out handler. Observes wheather a character is alive or knocked out.
 */
public class KnockedOutHandler implements Handler{
    private Character character;
    private Battle battle;

    /**
     * Instantiates a new Knocked out handler.
     *
     * @param character the character
     * @param battle    the battle
     */
    public KnockedOutHandler(Character character, Battle battle) {
        this.character = character;
        this.battle = battle;
    }

    /**
     * Calls onDeath method in abstract character when the property change is fired.
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        character.onDeath(battle,(int) evt.getNewValue());
    }
}
