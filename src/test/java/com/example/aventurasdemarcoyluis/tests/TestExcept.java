package com.example.aventurasdemarcoyluis.tests;
import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.ItemUnavailableException;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestExcept {
    private Game game;
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testInvalidGamePlay() {
        Game game = new Game();
        Goomba goomba = new Goomba(1);
        Throwable exception = assertThrows(InvalidGamePlay.class, () -> game.getState().chooseTargetLuigi(goomba));
        assertEquals("You cannot choose a target now!", exception.getMessage());
    }
    @Test
    public void testInvalidCharacterAction() {
        Marcos marcos = new Marcos(1);
        Luigi luigi = new Luigi(1);
        marcos.setFp(0);
        luigi.setFp(0);
        Throwable exception = assertThrows(InvalidCharacterActionException.class, () -> marcos.jumpAttack(new Goomba(1)));
        assertEquals("Not enough Fp to perform action!", exception.getMessage());
        Throwable exception2 = assertThrows(InvalidCharacterActionException.class, () -> marcos.hammerAttack(new Goomba(1)));
        assertEquals("Not enough Fp to perform action!", exception.getMessage());
        Throwable exception3 = assertThrows(InvalidCharacterActionException.class, () -> luigi.jumpAttack(new Goomba(1)));
        assertEquals("Not enough Fp to perform action!", exception.getMessage());
        Throwable exception4 = assertThrows(InvalidCharacterActionException.class, () -> luigi.jumpAttack(new Goomba(1)));
        assertEquals("Not enough Fp to perform action!", exception.getMessage());
    }
    @Test
    public void testItemUnavailableException() {
        BagPack bag = new BagPack();
        Marcos marcos = new Marcos(1, bag);
        Throwable exception = assertThrows(ItemUnavailableException.class, () -> bag.useItem("RedMushroom", marcos));
        assertEquals("You currently don't have this item", exception.getMessage());
    }
}
