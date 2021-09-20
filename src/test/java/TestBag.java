import com.example.aventurasdemarcoyluis.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestBag {
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
    @Test
    public void equalsTest(){
        BagPack bagPack = new BagPack(testMarcos);
        BagPack bagPack2 = new BagPack(testMarcos);
        BagPack bagPack3 = new BagPack(testLuigi);
        assertTrue(bagPack.equals(bagPack2));
        assertTrue(!bagPack.equals(bagPack3));
    }
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
        assertEquals(1,luigiBagMushrooms);
        assertEquals(1,luigiBagSyrup);
        assertEquals(1,luigiBagStar);
        assertEquals(1,marcosBagMushrooms);
        assertEquals(1,marcosBagSyrup);
        assertEquals(1,marcosBagStar);
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
