package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Test enemy.
 */
public class TestEnemy {

    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;
    private Goomba testGoomba2;
    private Boo testBoo2;
    private Spiny testSpiny2;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(0);
        testBoo = new Boo(0);
        testSpiny = new Spiny(0);
        testGoomba2 = new Goomba(1, 10, 10, 10);
        testBoo2 = new Boo(1, 10, 10, 10);
        testSpiny2 = new Spiny(1, 10, 10, 10);
    }
    @Test
    public void equalsTest(){
        Goomba testGoomba2= new Goomba(0);
        Boo testBoo2 = new Boo(0);
        Spiny testSpiny2 = new Spiny(0);
        assertTrue(!testGoomba.equals(testGoomba2));
        assertTrue(!testBoo.equals(testBoo2));
        assertTrue(!testSpiny.equals(testSpiny2));
        assertTrue(!testGoomba.equals(testBoo));
        assertTrue(!testBoo.equals(testSpiny));
    }
    @Test
    public void toStringTest(){
        assertEquals("Goomba: lvl = 1, atk = 100, def = 100, hp = 100, isKnockedOut = false",testGoomba.toString());
        assertEquals("Boo: lvl = 1, atk = 100, def = 100, hp = 100, isKnockedOut = false",testBoo.toString());
        assertEquals("Spiny: lvl = 1, atk = 100, def = 100, hp = 100, isKnockedOut = false",testSpiny.toString());
    }
    /**
     * Constructor test.
     */
    @Test
    public void constructorTest(){
        assertEquals("Boo",testBoo.getType());
        assertEquals("Goomba",testGoomba.getType());
        assertEquals("Spiny",testSpiny.getType());
        assertEquals(10, testGoomba2.getHp());
        assertEquals(10, testGoomba2.getAtk());
        assertEquals(10, testGoomba2.getDef());
        assertEquals(10, testBoo2.getHp());
        assertEquals(10, testBoo2.getDef());
        assertEquals(10, testBoo2.getAtk());
        assertEquals(10, testSpiny2.getHp());
        assertEquals(10, testSpiny2.getDef());
        assertEquals(10, testSpiny2.getAtk());
    }

    /**
     * Set test.
     */
    @Test
    public void SetTest(){
        testGoomba.setHp(90);
        testBoo.setHp(90);
        testSpiny.setHp(90);
        testGoomba.setAtk(90);
        testBoo.setAtk(90);
        testSpiny.setAtk(90);
        assertEquals(90,testGoomba.getHp());
        assertEquals(90,testBoo.getHp());
        assertEquals(90,testSpiny.getHp());
        assertEquals(90,testGoomba.getAtk());
        assertEquals(90,testBoo.getAtk());
        assertEquals(90,testSpiny.getAtk());
    }

    /**
     * Border hp.
     */
    @Test
    public void borderHp(){
        testBoo.setHp(200);
        testGoomba.setHp(200);
        testSpiny.setHp(200);
        assertEquals(100,testBoo.getHp());
        assertEquals(100,testGoomba.getHp());
        assertEquals(100,testSpiny.getHp());
        testBoo.setHp(-50);
        testGoomba.setHp(-50);
        testSpiny.setHp(-50);
        assertEquals(0,testBoo.getHp());
        assertEquals(0,testGoomba.getHp());
        assertEquals(0,testSpiny.getHp());
    }

    /**
     * Get test.
     */
    @Test
    public void GetTest(){
        assertEquals(100,testGoomba.getHp());
        assertEquals(100,testBoo.getHp());
        assertEquals(100,testSpiny.getHp());
        assertEquals(100,testGoomba.getAtk());
        assertEquals(100,testBoo.getAtk());
        assertEquals(100,testSpiny.getAtk());
        assertEquals(100,testGoomba.getDef());
        assertEquals(100,testBoo.getDef());
        assertEquals(100,testSpiny.getDef());
        assertEquals(1,testGoomba.getLvl());
        assertEquals(1,testBoo.getLvl());
        assertEquals(1,testSpiny.getLvl());
    }

    /**
     * Up lvl.
     */
    @Test
    public void upLvl(){
        testBoo.setLvl(2);
        testGoomba.setLvl(2);
        testSpiny.setLvl(2);
        assertEquals(115,testBoo.getMaxHp());
        assertEquals(115,testGoomba.getMaxHp());
        assertEquals(115,testSpiny.getMaxHp());
        assertEquals(115,testBoo.getMaxAtk());
        assertEquals(115,testGoomba.getMaxAtk());
        assertEquals(115,testSpiny.getMaxAtk());
        assertEquals(115,testBoo.getMaxDef());
        assertEquals(115,testGoomba.getMaxDef());
        assertEquals(115,testSpiny.getMaxDef());
    }
}
