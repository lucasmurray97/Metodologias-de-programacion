package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Test bag.
 */
public class TestBag {
    /**
     * The Test marcos.
     */
    Marcos testMarcos;
    /**
     * The Test luigi.
     */
    Luigi testLuigi;


    /**
     * The Test mushroom.
     */
    RedMushroom testMushroom;
    /**
     * The Test honey syrup.
     */
    HoneySyrup testHoneySyrup;
    /**
     * The Test star.
     */
    Star testStar;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(0);
        testLuigi = new Luigi(0);
        testStar = new Star();
        testMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest(){
        BagPack bagPack = new BagPack(testMarcos);
        BagPack bagPack2 = new BagPack(testMarcos);
        BagPack bagPack3 = new BagPack(testLuigi);
        assertTrue(bagPack.equals(bagPack2));
        assertTrue(!bagPack.equals(bagPack3));
    }

    /**
     * To string test.
     */
    @Test
    public void toStringTest(){
        testLuigi.pickItem(testHoneySyrup);
        testLuigi.pickItem(testStar);
        testLuigi.pickItem(testMushroom);
        assertEquals("Luigi's BagPack, it contains: 1 HoneySyrups, 1 Stars, 1 RedMushrooms",testLuigi.getBag().toString());
    }

    /**
     * Pick item bag test.
     */
    @Test
    public void pickItemBagTest() {
        testMarcos.pickItem(testMushroom);
        testLuigi.pickItem(testMushroom);
        testMarcos.pickItem(testHoneySyrup);
        testLuigi.pickItem(testHoneySyrup);
        testMarcos.pickItem(testStar);
        testLuigi.pickItem(testStar);
        int luigiBagMushrooms = testLuigi.getQuantity("RedMushroom");
        int marcosBagMushrooms = testMarcos.getQuantity("RedMushroom");
        int luigiBagSyrup = testLuigi.getQuantity("HoneySyrup");
        int marcosBagSyrup = testMarcos.getQuantity("HoneySyrup");
        int luigiBagStar = testLuigi.getQuantity("Star");
        int marcosBagStar = testMarcos.getQuantity("Star");
        int marcosBagAny = testMarcos.getQuantity("Any");
        assertEquals(1,luigiBagMushrooms);
        assertEquals(1,luigiBagSyrup);
        assertEquals(1,luigiBagStar);
        assertEquals(1,marcosBagMushrooms);
        assertEquals(1,marcosBagSyrup);
        assertEquals(1,marcosBagStar);
        assertEquals(0,marcosBagAny);
        testMarcos.pickItem(testMushroom);
        testLuigi.pickItem(testMushroom);
        testMarcos.pickItem(testHoneySyrup);
        testLuigi.pickItem(testHoneySyrup);
        testMarcos.pickItem(testStar);
        testLuigi.pickItem(testStar);
        luigiBagMushrooms = testLuigi.getQuantity("RedMushroom");
        marcosBagMushrooms = testMarcos.getQuantity("RedMushroom");
        luigiBagSyrup = testLuigi.getQuantity("HoneySyrup");
        marcosBagSyrup = testMarcos.getQuantity("HoneySyrup");
        luigiBagStar = testLuigi.getQuantity("Star");
        marcosBagStar = testMarcos.getQuantity("Star");
        assertEquals(2,luigiBagMushrooms);
        assertEquals(2,luigiBagSyrup);
        assertEquals(2,luigiBagStar);
        assertEquals(2,marcosBagMushrooms);
        assertEquals(2,marcosBagSyrup);
        assertEquals(2,marcosBagStar);

    }

    /**
     * Use item test.
     */
    @Test
    public void useItemTest(){
        testMarcos.pickItem(testMushroom);
        testLuigi.pickItem(testMushroom);
        testMarcos.pickItem(testHoneySyrup);
        testLuigi.pickItem(testHoneySyrup);
        testMarcos.pickItem(testStar);
        testLuigi.pickItem(testStar);
        testMarcos.useItem("RedMushroom");
        testLuigi.useItem("RedMushroom");
        testMarcos.useItem("HoneySyrup");
        testLuigi.useItem("HoneySyrup");
        testMarcos.useItem("Star");
        testLuigi.useItem("Star");
        int luigiBagMushrooms = testLuigi.getQuantity("RedMushroom");
        int marcosBagMushrooms = testMarcos.getQuantity("RedMushroom");
        int luigiBagSyrup = testLuigi.getQuantity("HoneySyrup");
        int marcosBagSyrup = testMarcos.getQuantity("HoneySyrup");
        int luigiBagStar = testLuigi.getQuantity("Star");
        int marcosBagStar = testMarcos.getQuantity("Star");
        assertEquals(0,luigiBagMushrooms);
        assertEquals(0,luigiBagSyrup);
        assertEquals(0,luigiBagStar);
        assertEquals(0,marcosBagMushrooms);
        assertEquals(0,marcosBagSyrup);
        assertEquals(0,marcosBagStar);
    }
}
