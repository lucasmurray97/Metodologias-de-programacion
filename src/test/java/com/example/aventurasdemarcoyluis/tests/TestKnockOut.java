package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Test knock out.
 */
public class TestKnockOut {
    private Marcos testMarcos;
    private Luigi testLuigi;
    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testMarcos= new Marcos(0);
        testLuigi = new Luigi(0);
        testGoomba= new Goomba(0);
        testBoo = new Boo(0);
        testSpiny = new Spiny(0);
    }

    /**
     * Knockout test.
     */
    @Test
    public void KnockoutTest(){
        testMarcos.setHp(0);
        testLuigi.setHp(0);
        testGoomba.setHp(0);
        testBoo.setHp(0);
        testSpiny.setHp(0);
        assertTrue(testLuigi.isKnockedOut());
        assertTrue(testMarcos.isKnockedOut());
        assertTrue(testGoomba.isKnockedOut());
        assertTrue(testBoo.isKnockedOut());
        assertTrue(testSpiny.isKnockedOut());
        assertEquals(0, testMarcos.getAtk());
        assertEquals(0, testLuigi.getAtk());
        assertEquals(0, testGoomba.getAtk());
        assertEquals(0, testBoo.getAtk());
        assertEquals(0, testSpiny.getAtk());
        testLuigi.getState().revive();
        testMarcos.getState().revive();
        testGoomba.getState().revive();
        testBoo.getState().revive();
        testSpiny.getState().revive();
        assertEquals(100, testMarcos.getAtk());
        assertEquals(100, testLuigi.getAtk());
        assertEquals(100, testGoomba.getAtk());
        assertEquals(100, testBoo.getAtk());
        assertEquals(100, testSpiny.getAtk());
    }
}
