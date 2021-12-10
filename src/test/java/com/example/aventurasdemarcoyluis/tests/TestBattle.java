package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.IBattle;
import com.example.aventurasdemarcoyluis.model.Battle.NullBattle;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.*;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.Items.Star;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


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
    public void setUp() throws InvalidGamePlay {
        testBag = new BagPack();
        testMarcos = new Marcos(1, testBag);
        testLuigi = new Luigi(1, testBag);
        testGoomba= new Goomba(1);
        testBoo = new Boo(1);
        testSpiny = new Spiny(1);
        battle = new Battle(3, 1, testBag, testLuigi, testMarcos);
    }
    /**
     * General Functionalities of battle.
     */
    @Test
    public void generalFunctionalitiesTest() {
        this.battle.setOutcome(1);
        assertEquals(1, this.battle.getOutcome());
        Random random = new Random();
        this.battle.setRandom(random);
        assertEquals(random, this.battle.getRandom());
        SpinyTurn spinyTurn = new SpinyTurn();
        this.battle.setState(spinyTurn);
        assertTrue(this.battle.isSpinyTurn());
        assertEquals(spinyTurn, this.battle.getState());
        assertEquals(testBag, this.battle.getBagPack());
        int n = this.battle.getCharacters().size();
        int m =  this.battle.getEnemies().size();
        int p = this.battle.getPlayers().size();
        this.battle.addCharacter(testBoo);
        assertEquals(n+1, this.battle.getCharacters().size());
        this.battle.addEnemy(testGoomba);
        assertEquals(n+2, this.battle.getCharacters().size());
        assertEquals(m+1, this.battle.getEnemies().size());
        Luigi luigi2 = new Luigi(1);
        this.battle.addPlayer(luigi2);
        assertEquals(n+3, this.battle.getCharacters().size());
        assertEquals(p+1, this.battle.getPlayers().size());
        this.battle.addRandomEnemy(1);
        assertEquals(n+4, this.battle.getCharacters().size());
        assertEquals(m+2, this.battle.getEnemies().size());

    }
    /**
     * Turns Tests
     */
    @Test
    public void battleStateTest(){
        this.battle.setState(new BattleState());
        assertTrue(!this.battle.isOver());
        assertTrue(!this.battle.isMarcosTurn());
        assertTrue(!this.battle.isLuigisTurn());
        assertTrue(!this.battle.isEnemyTurn());
        assertTrue(!this.battle.isBooTurn());
        assertTrue(!this.battle.isSpinyTurn());
        assertTrue(!this.battle.isGoombaTurn());
        assertTrue(!this.battle.getState().isPlayerTurn());
        assertTrue(this.battle.getState().isMarcosAlive());
        assertTrue(this.battle.getState().isLuigiAlive());
        assertTrue(this.battle.getState().anyEnemiesAlive());
        Throwable error = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.getState().setCurrent(1);
        });
        Assertions.assertEquals("Wrong State", error.getMessage());
    }
    @Test
    public void overStateTest(){
        this.battle.setState(new Over());
        assertTrue(this.battle.isOver());
        Throwable error1 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.terminate();
        });
        Assertions.assertEquals("Wrong State", error1.getMessage());
        Throwable error2 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseItem("RedMushroom");
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        Throwable error3 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.choosePlayer(testMarcos);
        });
        Assertions.assertEquals("Wrong State", error3.getMessage());
        Throwable error4 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetMarcos(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error4.getMessage());
        Throwable error5 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetLuigi(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error5.getMessage());
       Throwable error6 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.normalAttack();
        });
        Assertions.assertEquals("Wrong State", error6.getMessage());
    }
    @Test
    public void enemyTurnTest() throws InvalidGamePlay {
        this.battle.setState(new EnemyTurn());
        this.battle.getState().setCurrent(0);
        this.battle.getState().setEnemyTurn();
        assertTrue(this.battle.isEnemyTurn());
        Throwable error2 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseItem("RedMushroom");
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        Throwable error3 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.choosePlayer(testMarcos);
        });
        Assertions.assertEquals("Wrong State", error3.getMessage());
        Throwable error4 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetMarcos(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error4.getMessage());
        Throwable error5 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetLuigi(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error5.getMessage());
        this.battle.normalAttack();
        assertTrue(this.battle.isEnemyTurn());
    }
    @Test
    public void booStateTest() throws InvalidGamePlay {
        this.battle.setState(new BooTurn());
        this.battle.setCurrentCharacter(testBoo);
        assertEquals(testBoo, this.battle.getCurrentPlayer());
        assertTrue(this.battle.isEnemyTurn());
        assertTrue(this.battle.isBooTurn());
        this.battle.normalAttack();
        assertTrue(this.battle.isEnemyTurn());
    }
    @Test
    public void goombaStateTest() throws InvalidGamePlay {
        this.battle.setState(new GoombaTurn());
        this.battle.setCurrentCharacter(testGoomba);
        assertEquals(testGoomba, this.battle.getCurrentPlayer());
        assertTrue(this.battle.isEnemyTurn());
        assertTrue(this.battle.isGoombaTurn());
        this.battle.normalAttack();
        assertTrue(this.battle.isEnemyTurn());
    }
    @Test
    public void spinyStateTest() throws InvalidGamePlay {
        this.battle.setState(new SpinyTurn());
        this.battle.setCurrentCharacter(testSpiny);
        assertEquals(testSpiny, this.battle.getCurrentPlayer());
        assertTrue(this.battle.isEnemyTurn());
        assertTrue(this.battle.isSpinyTurn());
        this.battle.normalAttack();
        assertTrue(this.battle.isEnemyTurn());
    }
    @Test
    public void luigiStateTest() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.getLuigi().setFp(50);
        this.battle.setState(new LuigisTurn());
        this.battle.setCurrentCharacter(testLuigi);
        assertEquals(testLuigi, this.battle.getCurrentPlayer());
        assertTrue(this.battle.isLuigisTurn());
        assertTrue(this.battle.isPlayerTurn());
        Throwable error2 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.normalAttack();
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        Throwable error3 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetMarcos(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error3.getMessage());
        Throwable error4 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.marcosJumpAttack();
        });
        Assertions.assertEquals("Wrong State", error4.getMessage());
        Throwable error5 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.marcosHammerAttack();
        });
        Assertions.assertEquals("Wrong State", error5.getMessage());
        this.battle.chooseTargetLuigi(testGoomba);
        this.battle.luigiHammerAttack();
        assertTrue(this.battle.isEnemyTurn());
        this.battle.setState(new LuigisTurn());
        this.battle.setCurrentCharacter(testLuigi);
        testBag.addItem(new RedMushroom());
        this.battle.chooseItem("RedMushroom");
        this.battle.choosePlayer(testLuigi);
        assertTrue(this.battle.isEnemyTurn());
    }
    @Test
    public void marcosStateTest() throws InvalidCharacterActionException, InvalidGamePlay {
        this.battle.getMarcos().setFp(50);
        this.battle.setState(new MarcosTurn());
        this.battle.setCurrentCharacter(testMarcos);
        assertEquals(testMarcos, this.battle.getCurrentPlayer());
        assertTrue(this.battle.isMarcosTurn());
        assertTrue(this.battle.isPlayerTurn());
        Throwable error2 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.normalAttack();
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        Throwable error3 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.chooseTargetLuigi(testGoomba);
        });
        Assertions.assertEquals("Wrong State", error3.getMessage());
        Throwable error4 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.luigiJumpAttack();
        });
        Assertions.assertEquals("Wrong State", error4.getMessage());
        Throwable error5 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            this.battle.luigiHammerAttack();
        });
        Assertions.assertEquals("Wrong State", error5.getMessage());
        this.battle.chooseTargetMarcos(testGoomba);
        this.battle.marcosHammerAttack();
        assertTrue(this.battle.isLuigisTurn());
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
        assertEquals(expectedBag, currentBag);
        assertEquals(testMarcos, currentPlayer);
        assertTrue(battle.isMarcosTurn());
        assertEquals(5, this.battle.getCharacters().size());
        assertEquals(2, this.battle.getPlayers().size());
        assertEquals(3, this.battle.getEnemies().size());
    }
    @Test
    public void firstTurnAttackTest() throws InvalidCharacterActionException, InvalidGamePlay {
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
    public void firstTurnItemTest() throws InvalidGamePlay {
        testMarcos.setHp(50);
        int expectedHp = testMarcos.getHp() + (int) (testMarcos.getMaxHp()*0.1);
        assertTrue(battle.isMarcosTurn());
        testBag.addItem(new RedMushroom());
        battle.chooseItem("RedMushroom");
        battle.choosePlayer(testMarcos);
        assertEquals(expectedHp, testMarcos.getHp());
        assertEquals(testLuigi, battle.getCurrentPlayer());
        assertEquals(0, testBag.getQuantity("RedMushroom"));
        assertTrue(battle.isLuigisTurn());
    }
    @Test
    public void firstTurnPassTest() throws InvalidGamePlay {
        battle.terminate();
        assertEquals(testLuigi, battle.getCurrentPlayer());
        assertTrue(battle.isLuigisTurn());
    }
    @Test
    public void secondTurnTest() throws InvalidCharacterActionException, InvalidGamePlay {
        battle.terminate();
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
    public void thirdTurnTest() throws InvalidGamePlay {
        Random random = new Random();
        random.setSeed(2);
        battle.setSeed(2);
        battle.terminate();
        battle.terminate();
        assertTrue(battle.isEnemyTurn());
        Character expectedCurrentPlayer = battle.getEnemies().get(0);
        Player chosenPlayer = battle.getPlayers().get(random.nextInt(2));
        int hp = chosenPlayer.getHp();
        Character currentPlayer = battle.getCurrentPlayer();
        assertEquals(expectedCurrentPlayer, currentPlayer);
        battle.normalAttack();
        int damage = (int) Math.round(0.75 * currentPlayer.getAtk() * (chosenPlayer.getLvl() / (double) chosenPlayer.getDef()));
        assertEquals(hp-damage, chosenPlayer.getHp());
        assertTrue(battle.isEnemyTurn());
        assertEquals(1, battle.getState().getCurrent());
        expectedCurrentPlayer = battle.getEnemies().get(1);
        assertEquals(expectedCurrentPlayer, this.battle.getCurrentPlayer());
        battle.normalAttack();
        assertEquals(2, battle.getState().getCurrent());
        expectedCurrentPlayer = battle.getEnemies().get(2);
        assertEquals(expectedCurrentPlayer, this.battle.getCurrentPlayer());
        battle.normalAttack();
        assertTrue(battle.isMarcosTurn());
    }
    @Test
    public void testPlayerDeath() throws InvalidGamePlay {
        battle.setState(new EnemyTurn());
        testLuigi.setHp(0);
        testMarcos.setHp(0);
        battle.terminate();
        assertEquals(0, this.battle.getPlayers().size());
        assertTrue(battle.isOver());
    }
    @Test
    public void testEnemiesDeath() throws InvalidGamePlay {
        int n = battle.getEnemies().size();
        for(int i=0; i<n; i++){
            battle.getEnemies().get(0).setHp(0);
        }
        battle.terminate();
        assertEquals(0, this.battle.getEnemies().size());
        assertTrue(battle.isOver());
    }
    @Test
    public void testEnemiesDeath2() throws InvalidGamePlay {
        battle.terminate();
        int n = battle.getEnemies().size();
        for(int i=0; i<n; i++){
            battle.getEnemies().get(0).setHp(0);
        }
        battle.terminate();
        assertEquals(0, this.battle.getEnemies().size());
        assertTrue(battle.isOver());
    }
    @Test
    public void testLuigiDeath() throws InvalidGamePlay {
        testLuigi.setHp(0);
        battle.terminate();
        assertTrue(battle.isEnemyTurn());
    }
    @Test
    public void testNullBattle(){
        IBattle nullBattle = new NullBattle();
        assertEquals(nullBattle.getState(),null);
        assertEquals(nullBattle.getCharacters(),new ArrayList<>());
        assertEquals(nullBattle.getBagPack(), null);
        assertEquals(nullBattle.isOver(),false);
        assertEquals(nullBattle.getOutcome(), 0);
        assertEquals(nullBattle.getCurrentPlayer().getType(), null);
        assertEquals(nullBattle.getPlayers(), null);
        assertTrue(!nullBattle.isLuigisTurn());
        assertTrue(!nullBattle.isMarcosTurn());
        assertTrue(!nullBattle.isBooTurn());
        assertTrue(!nullBattle.isSpinyTurn());
        assertTrue(!nullBattle.isGoombaTurn());
        assertTrue(!nullBattle.isEnemyTurn());
        assertTrue(!nullBattle.isPlayerTurn());
        assertEquals(nullBattle.getEnemies(), null);
        assertEquals(nullBattle.getLuigi(), null);
        assertEquals(nullBattle.getMarcos(), null);
        assertEquals(nullBattle.getNextCharacter(), null);
    }
}
