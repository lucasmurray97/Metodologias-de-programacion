package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.classes.Luigi;
import com.example.aventurasdemarcoyluis.classes.Marcos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Test player.
 */
public class TestPlayer {

    private Marcos testMarcos;
    private Luigi testLuigi;


    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testMarcos= new Marcos(1);
        testLuigi = new Luigi(1);
    }

    /**
     * Constructor test.
     */
    @Test
    public void constructorTest(){
        assertEquals("Luigi",testLuigi.getType());
        assertEquals("Marcos",testMarcos.getType());
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest(){
        Marcos testMarcos2= new Marcos(1);
        Luigi testLuigi2 = new Luigi(1);
        assertTrue(testLuigi.equals(testLuigi2));
        assertTrue(testMarcos.equals(testMarcos2));
        assertTrue(!testLuigi.equals(testMarcos));
    }

    /**
     * To string test.
     */
    @Test
    public void toStringTest(){
        assertEquals("Luigi: lvl = 1, atk = 100, def = 100, hp = 100, isKnockedOut = false",testLuigi.toString());
        assertEquals("Luigi: lvl = 1, atk = 100, def = 100, hp = 100, isKnockedOut = false",testLuigi.toString());
    }

    /**
     * Set test.
     */
    @Test
    public void SetTest(){
        testLuigi.setHp(90);
        testMarcos.setHp(90);
        testLuigi.setAtk(90);
        testMarcos.setAtk(90);
        testLuigi.setDef(90);
        testMarcos.setDef(90);
        testLuigi.setFp(10);
        testMarcos.setFp(10);
        assertEquals(90,testLuigi.getHp());
        assertEquals(90,testMarcos.getHp());
        assertEquals(90,testLuigi.getAtk());
        assertEquals(90,testMarcos.getAtk());
        assertEquals(90,testLuigi.getDef());
        assertEquals(90,testMarcos.getDef());
        assertEquals(10,testLuigi.getFp());
        assertEquals(10,testMarcos.getFp());
    }

    /**
     * Border hp.
     */
    @Test
    public void borderHp(){
        testLuigi.setHp(200);
        testMarcos.setHp(200);
        assertEquals(100,testLuigi.getHp());
        assertEquals(100,testMarcos.getHp());
        testLuigi.setHp(-50);
        testMarcos.setHp(-50);
        assertEquals(0,testLuigi.getHp());
        assertEquals(0,testMarcos.getHp());
    }

    /**
     * Get test.
     */
    @Test
    public void GetTest(){
        assertEquals(100,testMarcos.getHp());
        assertEquals(100,testLuigi.getHp());
        assertEquals(100,testMarcos.getAtk());
        assertEquals(100,testLuigi.getAtk());
        assertEquals(100,testMarcos.getDef());
        assertEquals(100,testLuigi.getDef());
        assertEquals(1,testMarcos.getLvl());
        assertEquals(1,testLuigi.getLvl());
    }

    /**
     * Up lvl.
     */
    @Test
    public void upLvl(){
        testMarcos.setLvl(2);
        testLuigi.setLvl(2);
        assertEquals(115,testLuigi.getMaxHp());
        assertEquals(115,testMarcos.getMaxHp());
        assertEquals(115,testLuigi.getMaxAtk());
        assertEquals(115,testMarcos.getMaxAtk());
        assertEquals(115,testLuigi.getMaxDef());
        assertEquals(115,testMarcos.getMaxDef());
    }
}
