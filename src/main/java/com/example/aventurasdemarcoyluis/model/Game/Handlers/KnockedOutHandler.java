package com.example.aventurasdemarcoyluis.model.Game.Handlers;

import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Game.GameStates.InBattle;

import java.beans.PropertyChangeEvent;

public class KnockedOutHandler implements Handler{
    private Character character;
    private Battle battle;
    public KnockedOutHandler(Character character, Battle battle) {
        this.character = character;
        this.battle = battle;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        character.onDeath(battle,(int) evt.getNewValue());
    }
}
