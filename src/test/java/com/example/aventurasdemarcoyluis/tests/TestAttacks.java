package com.example.aventurasdemarcoyluis.tests;
import com.example.aventurasdemarcoyluis.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestAttacks {
    private Marcos testMarcos;
    private Luigi testLuigi;
    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(0);
        testLuigi = new Luigi(0);
        testGoomba = new Goomba(0);
        testBoo = new Boo(0);
        testSpiny = new Spiny(0);
    }

    @Test
    public void marcosJumpAtkTest() {
        int booHp = testBoo.getHp();
        int goombaHp = testGoomba.getHp();
        int spinyHp = testSpiny.getHp();
        int marcosHp = testMarcos.getHp();
        int damageMarcosJumpBoo = testMarcos.getAtk() * (testMarcos.getLvl() / testBoo.getDef());
        int damageMarcosJumpGoomba = testMarcos.getAtk() * (testMarcos.getLvl() / testGoomba.getDef());
        int damageMarcosJumpSpiny = 0;
        int damageMarcosJumpSpinyMarcos = (int) (testMarcos.getHp() * 0.05);
        testMarcos.jumpAttack(testBoo);
        testMarcos.jumpAttack(testGoomba);
        testMarcos.jumpAttack(testSpiny);
        assertEquals(booHp - damageMarcosJumpBoo, testBoo.getHp());
        assertEquals(goombaHp - damageMarcosJumpGoomba, testGoomba.getHp());
        assertEquals(spinyHp - damageMarcosJumpSpiny, testSpiny.getHp());
        assertEquals(marcosHp - damageMarcosJumpSpinyMarcos, testMarcos.getHp());

    }

    @Test
    public void luigiJumpAtkTest() {
        int goombaHp = testGoomba.getHp();
        int spinyHp = testSpiny.getHp();
        int luigiHp = testLuigi.getHp();
        int damageLuigiJumpGoomba = testLuigi.getAtk() * (testLuigi.getLvl() / testGoomba.getDef());
        int damageLuigiJumpSpiny = 0;
        int damageLuigiJumpSpinyLuigi = (int) (testLuigi.getHp() * 0.05);
        testLuigi.jumpAttack(testGoomba);
        testLuigi.jumpAttack(testSpiny);
        assertEquals(goombaHp - damageLuigiJumpGoomba, testGoomba.getHp());
        assertEquals(spinyHp - damageLuigiJumpSpiny, testSpiny.getHp());
        assertEquals(luigiHp - damageLuigiJumpSpinyLuigi, testLuigi.getHp());
    }

    @Test
    public void marcosHammerAtkTest() {
        Random random = new Random();
        random.setSeed(2);
        testLuigi.setSeed(2);
        testMarcos.setSeed(2);
        int booHp = testBoo.getHp();
        int goombaHp = testGoomba.getHp();
        int spinyHp = testSpiny.getHp();
        int marcosHp = testMarcos.getHp();
        int damageMarcosHammerBoo = 0;
        int damageMarcosHammerGoomba = (int) (1.5 * testMarcos.getAtk() * (testMarcos.getLvl() / testGoomba.getDef()));
        int damageMarcosHammerSpiny = (int) (1.5 * testMarcos.getAtk() * (testMarcos.getLvl() / testGoomba.getDef()));
        int damageMarcosHammerSpinyMarcos = 0;
        int count = 0;
        while(count == 0) {
            if(random.nextInt(4)==0){
                count++;
            }
            testMarcos.hammerAttack(testBoo);
            testMarcos.hammerAttack(testGoomba);
            testMarcos.hammerAttack(testSpiny);
        }
        assertEquals(booHp - damageMarcosHammerBoo, testBoo.getHp());
        assertEquals(goombaHp - damageMarcosHammerGoomba, testGoomba.getHp());
        assertEquals(spinyHp - damageMarcosHammerSpiny, testSpiny.getHp());
        assertEquals(marcosHp - damageMarcosHammerSpinyMarcos, testMarcos.getHp());

    }

    @Test
    public void luigiHammerAtkTest() {
        Random random = new Random();
        random.setSeed(2);
        testLuigi.setSeed(2);
        testMarcos.setSeed(2);
        int goombaHp = testGoomba.getHp();
        int spinyHp = testSpiny.getHp();
        int luigiHp = testLuigi.getHp();
        int damageLuigiHammerGoomba = (int) (1.5 * testLuigi.getAtk() * (testLuigi.getLvl() / testGoomba.getDef()));
        int damageLuigiHammerSpiny = (int) (1.5 * testLuigi.getAtk() * (testLuigi.getLvl() / testGoomba.getDef()));
        int damageLuigiHammerSpinyLuigi = 0;
        int count = 0;
        while(count == 0) {
            if(random.nextInt(4)==0){
                count++;
            }
            testLuigi.hammerAttack(testGoomba);
            testLuigi.hammerAttack(testSpiny);
        }
        assertEquals(goombaHp - damageLuigiHammerGoomba, testGoomba.getHp());
        assertEquals(spinyHp - damageLuigiHammerSpiny, testSpiny.getHp());
        assertEquals(luigiHp - damageLuigiHammerSpinyLuigi, testLuigi.getHp());

    }

    @Test
    public void enemyNormalAtk() {
        int marcosHp = testMarcos.getHp();
        int luigiHp = testLuigi.getHp();
        int damageGoombaNormalMarcos = (int) (0.75 * testGoomba.getAtk() * (testMarcos.getLvl() / testMarcos.getDef()));
        int damageGoombaNormalLuigi = (int) (0.75 * testGoomba.getAtk() * (testLuigi.getLvl() / testLuigi.getDef()));
        int damageSpinyNormalMarcos = (int) (0.75 * testSpiny.getAtk() * (testMarcos.getLvl() / testMarcos.getDef()));
        int damageSpinyNormalLuigi = (int) (0.75 * testSpiny.getAtk() * (testLuigi.getLvl() / testLuigi.getDef()));
        int damageBooNormalLuigi = (int) (0.75 * testBoo.getAtk() * (testLuigi.getLvl() / testLuigi.getDef()));
        testBoo.normalAttack(testLuigi);
        assertEquals(luigiHp - damageBooNormalLuigi, testLuigi.getHp());
        testMarcos.setHp(marcosHp);
        testLuigi.setHp(luigiHp);
        testGoomba.normalAttack(testMarcos);
        testGoomba.normalAttack(testLuigi);
        assertEquals(marcosHp - damageGoombaNormalMarcos, testMarcos.getHp());
        assertEquals(luigiHp - damageGoombaNormalLuigi, testLuigi.getHp());
        testMarcos.setHp(marcosHp);
        testLuigi.setHp(luigiHp);
        testSpiny.normalAttack(testMarcos);
        testSpiny.normalAttack(testLuigi);
        assertEquals(marcosHp - damageSpinyNormalMarcos, testMarcos.getHp());
        assertEquals(luigiHp - damageSpinyNormalLuigi, testLuigi.getHp());
    }
}


