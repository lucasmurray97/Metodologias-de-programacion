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
    private BagPack testBag;

    @BeforeEach
    public void setUp() {
        testBag = new BagPack();
        testMarcos = new Marcos(1, testBag);
        testLuigi = new Luigi(1, testBag);
        testGoomba = new Goomba(1);
        testBoo = new Boo(1);
        testSpiny = new Spiny(1);
    }

    @Test
    public void marcosJumpAtkTest() {
        int booHp = testBoo.getHp();
        int goombaHp = testGoomba.getHp();
        int spinyHp = testSpiny.getHp();
        int marcosHp = testMarcos.getHp();
        int damageMarcosJumpBoo = (int) Math.round(testMarcos.getAtk() * (testMarcos.getLvl() / (double)testBoo.getDef()));
        int damageMarcosJumpGoomba = (int) Math.round(testMarcos.getAtk() * (testMarcos.getLvl() / (double)testGoomba.getDef()));
        int damageMarcosJumpSpiny = 0;;
        int damageMarcosJumpSpinyMarcos = (int) Math.round(testMarcos.getHp() * 0.05);
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
        int damageLuigiJumpGoomba = (int) Math.round(testLuigi.getAtk() * (testLuigi.getLvl() / (double)testGoomba.getDef()));
        int damageLuigiJumpSpiny = 0;
        int damageLuigiJumpSpinyLuigi = (int) Math.round(testLuigi.getHp() * 0.05);
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
        int damageMarcosHammerGoomba = (int) Math.round(1.5 * testMarcos.getAtk() * (testMarcos.getLvl() / (double) testGoomba.getDef()));
        int damageMarcosHammerSpiny = (int) Math.round(1.5 * testMarcos.getAtk() * (testMarcos.getLvl() / (double) testGoomba.getDef()));
        int damageMarcosHammerSpinyMarcos = 0;
        int count = 0;
        while(count == 0) {
            int rand = random.nextInt(4);
            if(rand==0){
                count++;
            }
            testMarcos.hammerAttack(testBoo);
        }
        count = 0;
        while(count == 0) {
            int rand = random.nextInt(4);
            if(rand==0){
                count++;
            }
            testMarcos.hammerAttack(testGoomba);
        }
        count = 0;
        while(count == 0) {
            int rand = random.nextInt(4);
            if(rand==0){
                count++;
            }
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
        int damageLuigiHammerGoomba = (int) Math.round(1.5 * testLuigi.getAtk() * (testLuigi.getLvl() /(double) testGoomba.getDef()));
        int damageLuigiHammerSpiny = (int) Math.round(1.5 * testLuigi.getAtk() * (testLuigi.getLvl() / (double) testGoomba.getDef()));
        int damageLuigiHammerSpinyLuigi = 0;
        int count = 0;
        while(count == 0) {
            int rand = random.nextInt(4);
            if(rand==0){
                count++;
            }
            testLuigi.hammerAttack(testGoomba);
        }
        count = 0;
        while(count == 0) {
            int rand = random.nextInt(4);
            if(rand==0){
                count++;
            }
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
        int damageGoombaNormalMarcos = (int) Math.round(0.75 * testGoomba.getAtk() * (testMarcos.getLvl() / (double) testMarcos.getDef()));
        int damageGoombaNormalLuigi = (int) Math.round(0.75 * testGoomba.getAtk() * (testLuigi.getLvl() / (double) testLuigi.getDef()));
        int damageSpinyNormalMarcos = (int) Math.round(0.75 * testSpiny.getAtk() * (testMarcos.getLvl() / (double) testMarcos.getDef()));
        int damageSpinyNormalLuigi = (int) Math.round(0.75 * testSpiny.getAtk() * (testLuigi.getLvl() / (double) testLuigi.getDef()));
        int damageBooNormalLuigi = (int) Math.round(0.75 * testBoo.getAtk() * (testLuigi.getLvl() / (double) testLuigi.getDef()));
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


