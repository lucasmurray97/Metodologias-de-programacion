package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.NullCharacter;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.model.Characters.States.CharacterState;
import org.junit.jupiter.api.Assertions;
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
    private Marcos testMarcos2;
    private Luigi testLuigi2;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        testMarcos= new Marcos(1);
        testLuigi = new Luigi(1);
        testMarcos2 = new Marcos(1, 10, 10, 10, new BagPack());
        testLuigi2 = new Luigi(1, 10, 10, 10, new BagPack());
    }

    /**
     * Constructor test.
     */
    @Test
    public void constructorTest(){
        assertEquals("Luigi",testLuigi.getType());
        assertEquals("Marcos",testMarcos.getType());
        assertEquals(10, testLuigi2.getHp());
        assertEquals(10, testLuigi2.getAtk());
        assertEquals(10, testLuigi2.getDef());
        assertEquals(10, testMarcos2.getHp());
        assertEquals(10, testMarcos2.getDef());
        assertEquals(10, testMarcos2.getAtk());
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest(){
        Marcos testMarcos2= new Marcos(1);
        Luigi testLuigi2 = new Luigi(1);
        assertTrue(!testLuigi.equals(testLuigi2));
        assertTrue(!testMarcos.equals(testMarcos2));
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
    @Test
    public void state(){
        testMarcos.setState(new CharacterState());
        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
           testMarcos.getState().error();
        });
        Assertions.assertEquals("Wrong state", error.getMessage());
        AssertionError error2 = Assertions.assertThrows(AssertionError.class, () -> {
            testMarcos.getState().knockOut();
        });
        Assertions.assertEquals("Wrong state", error2.getMessage());
        AssertionError error4 = Assertions.assertThrows(AssertionError.class, () -> {
            testMarcos.getState().jumpAttack();
        });
        Assertions.assertEquals("Wrong state", error4.getMessage());
        AssertionError error5 = Assertions.assertThrows(AssertionError.class, () -> {
            testMarcos.getState().hammerAttack();
        });
        Assertions.assertEquals("Wrong state", error5.getMessage());
        AssertionError error6 = Assertions.assertThrows(AssertionError.class, () -> {
            testMarcos.getState().normalAttacked();
        });
        Assertions.assertEquals("Wrong state", error6.getMessage());
    }
    @Test public void testNullCharacter(){
        Character nullCharacter = new NullCharacter();
        assertEquals(nullCharacter.getType(), null);
        assertEquals(nullCharacter.getMaxAtk(),0);
        assertEquals(nullCharacter.getMaxHp(),0);
        assertTrue(!nullCharacter.isAlive());
        assertTrue(!nullCharacter.isKnockedOut());
        assertEquals(nullCharacter.getAtk(),0);
        assertEquals(nullCharacter.getLvl(),0);
    }
}
