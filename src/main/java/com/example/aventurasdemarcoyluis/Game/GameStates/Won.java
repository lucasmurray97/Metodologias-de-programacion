package com.example.aventurasdemarcoyluis.Game.GameStates;

/**
 * The State Won. The Game switches to this state if the players won the game.
 */
public class Won extends GameState {
    /**
     * Returns hasWon boolean, true if the players won the game.
     * @return
     */
    @Override
    public boolean hasWon() {
        return true;
    }
}
