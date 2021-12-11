package com.example.aventurasdemarcoyluis.model.Game.Exceptions;

/**
 * The type Item unavailable exception. Thrown when the item requested doesn't exist.
 */
public class ItemUnavailableException extends Exception {
    /**
     * Instantiates a new Item unavailable exception.
     *
     * @param message the message of the exception.
     */
    public ItemUnavailableException(String message) {
        super(message);
    }
}
