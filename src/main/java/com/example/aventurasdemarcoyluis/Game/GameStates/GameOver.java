package com.example.aventurasdemarcoyluis.Game.GameStates;

/**
 * The State Game over. The Game switches to this state if the players lost the game.
 */
public class GameOver extends GameState{
    /**
     * Returns Lost boolean, true if the players lost the game.
     * @return
     */
    @Override
    public boolean Lost() {
        return true;
    }
}
