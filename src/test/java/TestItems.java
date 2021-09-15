import com.example.aventurasdemarcoyluis.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestItems {
    Marcos testMarcos;
    Luigi testLuigi;
    Star testStar;
    RedMushroom testMushroom;
    HoneySyrup testHoneySyrup;
    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(0);
        testLuigi = new Luigi(0);

        testStar = new Star();
        testMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    @Test
    public void pickItemMushroomTest(){
        int marcosHpInit = testMarcos.getHp();
        int luigiHpInit = testLuigi.getHp();
        testMarcos.pickItem(testMushroom);
        testLuigi.pickItem(testMushroom);
        int expectedMarcos = (int) (marcosHpInit*1.1);
        int expectedLuigi = (int) (luigiHpInit*1.1);
        assertEquals(expectedMarcos,testMarcos.getHp());
        assertEquals(expectedLuigi,testLuigi.getHp());
    }
    @Test
    public void pickItemHoneySyrupTest(){
        int marcosFpInit = testMarcos.getFp();
        int luigiFpInit = testLuigi.getFp();
        testMarcos.pickItem(testHoneySyrup);
        testLuigi.pickItem(testHoneySyrup);
        assertEquals(3,testMarcos.getFp()-marcosFpInit);
        assertEquals(3, testLuigi.getFp()-luigiFpInit);
    }
}
