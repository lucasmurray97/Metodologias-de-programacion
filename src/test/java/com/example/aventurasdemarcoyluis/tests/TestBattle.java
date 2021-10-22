package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.classes.*;
import com.example.aventurasdemarcoyluis.interfaces.Character;
import com.example.aventurasdemarcoyluis.interfaces.Item;
import com.example.aventurasdemarcoyluis.interfaces.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Random;


public class TestBattle {
    private Marcos testMarcos;
    private Luigi testLuigi;
    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;
    private RedMushroom testMushroom;
    private HoneySyrup testHoneySyrup;
    private Star testStar;
    private Battle battle;
    private BagPack testBag;

    @BeforeEach
    public void setUp() {
        testBag = new BagPack();
        testMarcos = new Marcos(1, testBag);
        testLuigi = new Luigi(1, testBag);
        testGoomba= new Goomba(1);
        testBoo = new Boo(1);
        testSpiny = new Spiny(1);
        battle = new Battle(3, testBag, testLuigi, testMarcos);
    }
    @Test
    public void startOfBattleTest(){
        int outcome = battle.getOutcome();
        boolean isOver = battle.isOver();
        ArrayList<Character> characters = battle.getCharacters();
        ArrayList<Character> charactersExpected = new ArrayList<Character>();
        charactersExpected.add(testMarcos);
        charactersExpected.add(testLuigi);
        charactersExpected.add(testBoo);
        charactersExpected.add(testGoomba);
        charactersExpected.add(testSpiny);
        BagPack currentBag = battle.getBagPack();
        BagPack expectedBag = new BagPack();
        Character currentPlayer = battle.getCurrentPlayer();
        assertEquals(0, outcome);
        assertTrue(!isOver);
        //assertEquals(charactersExpected, characters);
        assertEquals(expectedBag, currentBag);
        assertEquals(testMarcos, currentPlayer);
        assertTrue(battle.isMarcosTurn());
    }
    @Test
    public void firstTurnAttackTest(){
        testMarcos.setFp(1);
        int expectedHp = testGoomba.getHp()-(int) Math.round(testMarcos.getAtk() * (testMarcos.getLvl() / (double)testGoomba.getDef()));
        battle.chooseTargetMarcos(testGoomba);
        battle.marcosJumpAttack();
        assertEquals(expectedHp, testGoomba.getHp());
        assertEquals(0, testMarcos.getFp());
        assertTrue(battle.isLuigisTurn());
        assertEquals(testLuigi, battle.getCurrentPlayer());
    }
    @Test
    public void firstTurnItemTest(){
        testMarcos.setHp(50);
        int expectedHp = testMarcos.getHp() + (int) (testMarcos.getMaxHp()*0.1);
        assertTrue(battle.isMarcosTurn());
        testBag.addItem(new RedMushroom());
        battle.chooseItem("RedMushroom");
        battle.choosePlayer(testMarcos);
        assertEquals(expectedHp, testMarcos.getHp());
        assertEquals(testLuigi, battle.getCurrentPlayer());
        assertTrue(battle.isLuigisTurn());
    }
    @Test
    public void firstTurnPassTest(){
        battle.pass();
        assertEquals(testLuigi, battle.getCurrentPlayer());
        assertTrue(battle.isLuigisTurn());
    }
    @Test
    public void secondTurnTest(){
        battle.pass();
        assertEquals(testLuigi, battle.getCurrentPlayer());
        assertTrue(battle.isLuigisTurn());
        testLuigi.setFp(1);
        int expectedHp = testGoomba.getHp()-(int) Math.round(testLuigi.getAtk() * (testLuigi.getLvl() / (double)testGoomba.getDef()));
        battle.chooseTargetLuigi(testGoomba);
        battle.luigiJumpAttack();
        assertEquals(expectedHp, testGoomba.getHp());
        assertEquals(0, testLuigi.getFp());
        assertTrue(battle.isEnemyTurn());
    }
    @Test
    public void thirdTurnTest(){
        Random random = new Random();
        random.setSeed(2);
        battle.setSeed();
        battle.pass();
        battle.pass();
        assertTrue(battle.isEnemyTurn());
        Player chosenPlayer = battle.getPlayers().get(random.nextInt(2));
        int hp = chosenPlayer.getHp();
        assertTrue(battle.isEnemyTurn());
        battle.randomAttack();
        battle.normalAttack();
        int damage = (int) Math.round(0.75 * testGoomba.getAtk() * (testMarcos.getLvl() / (double) testMarcos.getDef()));
        assertEquals(hp-damage, chosenPlayer.getHp());
        assertTrue(battle.isMarcosTurn());
    }
}
