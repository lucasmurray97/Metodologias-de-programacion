package com.example.aventurasdemarcoyluis.model.Game.Exceptions;

/**
 * The type Invalid game play. Thrown when that play can't be perfomed at that stage of the game.
 */
public class InvalidGamePlay extends Exception {
    /**
     * Instantiates a new Invalid game play.
     *
     * @param message the message fo the exception.
     */
    public InvalidGamePlay(final String message){
        super(message);
    }
}
