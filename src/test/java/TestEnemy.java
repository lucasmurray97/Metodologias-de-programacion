
import com.example.aventurasdemarcoyluis.*;
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

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(0);
        testBoo = new Boo(0);
        testSpiny = new Spiny(0);
    }
    @Test
    public void equalsTest(){
        Goomba testGoomba2= new Goomba(0);
        Boo testBoo2 = new Boo(0);
        Spiny testSpiny2 = new Spiny(0);
        assertTrue(testGoomba.equals(testGoomba2));
        assertTrue(testBoo.equals(testBoo2));
        assertTrue(testSpiny.equals(testSpiny2));
        assertTrue(!testGoomba.equals(testBoo));
        assertTrue(!testBoo.equals(testSpiny));
    }
    /**
     * Constructor test.
     */
    @Test
    public void constructorTest(){
        assertEquals("Boo",testBoo.getType());
        assertEquals("Goomba",testGoomba.getType());
        assertEquals("Spiny",testSpiny.getType());
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
        assertEquals(0,testGoomba.getLvl());
        assertEquals(0,testBoo.getLvl());
        assertEquals(0,testSpiny.getLvl());
    }

    /**
     * Up lvl.
     */
    @Test
    public void upLvl(){
        testBoo.setLvl(1);
        testGoomba.setLvl(1);
        testSpiny.setLvl(1);
        assertEquals(110,testBoo.getMaxHp());
        assertEquals(110,testGoomba.getMaxHp());
        assertEquals(110,testSpiny.getMaxHp());
        assertEquals(110,testBoo.getMaxAtk());
        assertEquals(110,testGoomba.getMaxAtk());
        assertEquals(110,testSpiny.getMaxAtk());
        assertEquals(110,testBoo.getMaxDef());
        assertEquals(110,testGoomba.getMaxDef());
        assertEquals(110,testSpiny.getMaxDef());
    }
}
