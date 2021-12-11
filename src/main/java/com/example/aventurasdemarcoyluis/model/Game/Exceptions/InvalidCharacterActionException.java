package com.example.aventurasdemarcoyluis.model.Game.Exceptions;

/**
 * The type Invalid character action exception. Is thrown when the character cannot perform that action in
 * it's current state.
 */
public class InvalidCharacterActionException extends Exception {
    /**
     * Instantiates a new Invalid character action exception.
     *
     * @param message the message of the exception
     */
    public InvalidCharacterActionException(String message) {
        super(message);
    }
}
