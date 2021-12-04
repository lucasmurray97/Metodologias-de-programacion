package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.model.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.Items.Star;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Test items.
 */
public class TestItems {
    /**
     * The Test marcos.
     */
    Marcos testMarcos;
    /**
     * The Test luigi.
     */
    Luigi testLuigi;
    /**
     * The Test star.
     */
    Star testStar;
    /**
     * The Test mushroom.
     */
    RedMushroom testMushroom;
    /**
     * The Test honey syrup.
     */
    HoneySyrup testHoneySyrup;

    /**
     * Sets up.
     */

    private BagPack testBag;
    @BeforeEach
    public void setUp() {
        testBag = new BagPack();
        testMarcos = new Marcos(0, testBag);
        testLuigi = new Luigi(0, testBag);
        testStar = new Star();
        testMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest(){
        Star testStar2 = new Star();
        RedMushroom testMushroom2 = new RedMushroom();
        HoneySyrup testHoneySyrup2 = new HoneySyrup();
        assertTrue(testMushroom.equals(testMushroom2));
        assertTrue(testHoneySyrup.equals(testHoneySyrup2));
        assertTrue(testStar.equals(testStar2));
        assertTrue(!testMushroom.equals(testHoneySyrup));
        assertTrue(!testStar.equals(testHoneySyrup));
    }

    /**
     * To string test.
     */
    @Test
    public void toStringTest(){
        assertEquals("RedMushroom",testMushroom.toString());
        assertEquals("HoneySyrup",testHoneySyrup.toString());
        assertEquals("Star",testStar.toString());
    }

    /**
     * Pick + Use item mushroom test.
     */
    @Test
    public void pickItemMushroomTest(){
        testMarcos.setHp(50);
        testLuigi.setHp(50);
        int marcosHpInit = testMarcos.getMaxHp();
        int luigiHpInit = testLuigi.getMaxHp();
        testBag.addItem(testMushroom);
        testBag.addItem(testMushroom);
        testMarcos.useItem("RedMushroom");
        testLuigi.useItem("RedMushroom");
        int expectedMarcos = 50 + (int) (marcosHpInit*0.1);
        int expectedLuigi = 50 + (int) (luigiHpInit*0.1);
        assertEquals(expectedMarcos,testMarcos.getHp());
        assertEquals(expectedLuigi,testLuigi.getHp());
    }

    /**
     * Pick + Use item honey syrup test.
     */
    @Test
    public void pickItemHoneySyrupTest(){
        int marcosFpInit = testMarcos.getFp();
        int luigiFpInit = testLuigi.getFp();
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testHoneySyrup);
        testMarcos.useItem("HoneySyrup");
        testLuigi.useItem("HoneySyrup");
        assertEquals(3,testMarcos.getFp()-marcosFpInit);
        assertEquals(3, testLuigi.getFp()-luigiFpInit);
    }

    /**
     * Pick + Use star test.
     */
    @Test
    public void pickStarTest(){
        testBag.addItem(testStar);
        testBag.addItem(testStar);
        testMarcos.useItem("Star");
        testLuigi.useItem("Star");
    }
}
