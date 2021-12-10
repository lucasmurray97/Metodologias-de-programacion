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
 * The type Test bag.
 */
public class TestBag {
    /**
     * The Test marcos.
     */
    private Marcos testMarcos;
    /**
     * The Test luigi.
     */
    private Luigi testLuigi;


    /**
     * The Test mushroom.
     */
    private RedMushroom testMushroom;
    /**
     * The Test honey syrup.
     */
    private HoneySyrup testHoneySyrup;
    /**
     * The Test star.
     */
    private Star testStar;

    private BagPack testBag;
    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testBag = new BagPack();
        testMarcos = new Marcos(0, testBag);
        testLuigi = new Luigi(0,testBag);
        testStar = new Star();
        testMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }


    /**
     * To string test.
     */
    @Test
    public void toStringTest(){
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testStar);
        testBag.addItem(testMushroom);
        assertEquals("This BagPack contains: 1 HoneySyrups, 1 Stars, 1 RedMushrooms",testLuigi.getBag().toString());
    }

    /**
     * Pick item bag test.
     */
    @Test
    public void pickItemBagTest() {
        testBag.addItem(testMushroom);
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testStar);
        int bagMushrooms = testBag.getQuantity("RedMushroom");
        int bagSyrup = testBag.getQuantity("HoneySyrup");
        int bagStar = testBag.getQuantity("Star");
        int bagAny = testBag.getQuantity("Any");
        assertEquals(1,bagMushrooms);
        assertEquals(1,bagSyrup);
        assertEquals(1,bagStar);
        assertEquals(0,bagAny);
        testBag.addItem(testMushroom);
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testStar);
        bagMushrooms = testBag.getQuantity("RedMushroom");
        bagSyrup = testBag.getQuantity("HoneySyrup");
        bagStar = testBag.getQuantity("Star");
        bagAny = testBag.getQuantity("Any");
        assertEquals(2,bagMushrooms);
        assertEquals(2,bagSyrup);
        assertEquals(2,bagStar);
    }

    /**
     * Use item test.
     */
    @Test
    public void useItemTest(){
        testBag.addItem(testMushroom);
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testStar);
        testBag.addItem(testMushroom);
        testBag.addItem(testHoneySyrup);
        testBag.addItem(testStar);
        testMarcos.useItem("RedMushroom");
        testLuigi.useItem("RedMushroom");
        testMarcos.useItem("HoneySyrup");
        testLuigi.useItem("HoneySyrup");
        testMarcos.useItem("Star");
        testLuigi.useItem("Star");
        int bagMushrooms = testBag.getQuantity("RedMushroom");
        int bagSyrup = testBag.getQuantity("HoneySyrup");
        int bagStar = testBag.getQuantity("Star");
        assertEquals(0,bagMushrooms);
        assertEquals(0,bagSyrup);
        assertEquals(0,bagStar);
    }
}
