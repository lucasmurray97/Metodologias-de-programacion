import com.example.aventurasdemarcoyluis.Luigi;
import com.example.aventurasdemarcoyluis.Marcos;
import com.example.aventurasdemarcoyluis.Luigi;
import com.example.aventurasdemarcoyluis.Player;
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
        testMarcos= new Marcos(0);
        testLuigi = new Luigi(0);
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
        assertEquals(0,testMarcos.getLvl());
        assertEquals(0,testLuigi.getLvl());
    }

    /**
     * Up lvl.
     */
    @Test
    public void upLvl(){
        testMarcos.setLvl(1);
        testLuigi.setLvl(1);
        assertEquals(110,testLuigi.getMaxHp());
        assertEquals(110,testMarcos.getMaxHp());
        assertEquals(110,testLuigi.getMaxAtk());
        assertEquals(110,testMarcos.getMaxAtk());
        assertEquals(110,testLuigi.getMaxDef());
        assertEquals(110,testMarcos.getMaxDef());
    }
}
