package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.Game.Battle.Battle;
import com.example.aventurasdemarcoyluis.Game.Game;
import com.example.aventurasdemarcoyluis.Game.GameStates.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {
    private Game game;
    @BeforeEach
    public void setUp() {
        this.game = new Game();
    }
    @Test
    public void testGameSetUp(){
        Luigi luigi = this.game.getLuigi();
        Marcos marcos = this.game.getMarcos();
        BagPack bag = this.game.getBagPack();
        assertEquals(new Luigi(1), luigi);
        assertEquals(new Marcos(1), marcos);
        assertEquals(new BagPack(), bag);
        assertTrue(this.game.getState().isPreparingBattle());
    }
    @Test
    public void generalFunctionalities(){
        this.game.setScore(2);
        assertEquals(2,this.game.getScore());
        game.addRedMushroom(3);
        assertEquals(3, game.getBagPack().getQuantity("RedMushroom"));
        game.createBattle(3);
        assertEquals(game.getCurrentPlayer(),game.getMarcos());
        assertEquals(game.getNextPlayer(),game.getLuigi());
        assertEquals(5,game.getCharacters().size());
    }
    @Test
    public void gameStateTest(){
        game.setState(new GameState());
        assertEquals(game, game.getState().getGame());
        assertTrue(!game.getState().isPreparingBattle());
        assertTrue(!game.getState().isInBattle());
        assertTrue(!game.getState().isOver());
        assertTrue(!game.getState().hasWon());
        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            game.createBattle(1);
        });
        Assertions.assertEquals("Wrong State", error.getMessage());
        AssertionError error2 = Assertions.assertThrows(AssertionError.class, () -> {
            game.createBattle();
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        AssertionError error3 = Assertions.assertThrows(AssertionError.class, () -> {
            game.addRandomEnemy(1);
        });
        Assertions.assertEquals("Wrong State", error3.getMessage());
        AssertionError error4 = Assertions.assertThrows(AssertionError.class, () -> {
            game.addHoneySyrup(1);
        });
        Assertions.assertEquals("Wrong State", error4.getMessage());
        AssertionError error5 = Assertions.assertThrows(AssertionError.class, () -> {
            game.addRedMushroom(1);
        });
        Assertions.assertEquals("Wrong State", error5.getMessage());
        AssertionError error6 = Assertions.assertThrows(AssertionError.class, () -> {
            game.getState().setBattle(new Battle());
        });
        Assertions.assertEquals("Wrong State", error2.getMessage());
        AssertionError error7 = Assertions.assertThrows(AssertionError.class, () -> {
            game.chooseTargetMarcos(new Goomba(1));
        });
        Assertions.assertEquals("Wrong State", error7.getMessage());
        AssertionError error8 = Assertions.assertThrows(AssertionError.class, () -> {
            game.marcosJumpAttack();
        });
        Assertions.assertEquals("Wrong State", error8.getMessage());
        AssertionError error9 = Assertions.assertThrows(AssertionError.class, () -> {
            game.marcosHammerAttack();
        });
        Assertions.assertEquals("Wrong State", error9.getMessage());
        AssertionError error10 = Assertions.assertThrows(AssertionError.class, () -> {
            game.luigiJumpAttack();
        });
        Assertions.assertEquals("Wrong State", error10.getMessage());
        AssertionError error11 = Assertions.assertThrows(AssertionError.class, () -> {
            game.luigiHammerAttack();
        });
        Assertions.assertEquals("Wrong State", error11.getMessage());
        AssertionError error12 = Assertions.assertThrows(AssertionError.class, () -> {
            game.normalAttack();
        });
        Assertions.assertEquals("Wrong State", error12.getMessage());
        AssertionError error13 = Assertions.assertThrows(AssertionError.class, () -> {
            game.chooseTargetLuigi(new Goomba(1));
        });
        Assertions.assertEquals("Wrong State", error13.getMessage());
        AssertionError error14 = Assertions.assertThrows(AssertionError.class, () -> {
            game.chooseItem("RedMushroom");
        });
        Assertions.assertEquals("Wrong State", error14.getMessage());
        AssertionError error15 = Assertions.assertThrows(AssertionError.class, () -> {
            game.terminate();
        });
        Assertions.assertEquals("Wrong State", error15.getMessage());
        AssertionError error16 = Assertions.assertThrows(AssertionError.class, () -> {
            game.levelUp();
        });
        Assertions.assertEquals("Wrong State", error16.getMessage());
        AssertionError error17 = Assertions.assertThrows(AssertionError.class, () -> {
            game.getCurrentPlayer();
        });
        Assertions.assertEquals("Wrong State", error17.getMessage());
        AssertionError error18 = Assertions.assertThrows(AssertionError.class, () -> {
            game.getNextPlayer();
        });
        Assertions.assertEquals("Wrong State", error18.getMessage());
        AssertionError error19 = Assertions.assertThrows(AssertionError.class, () -> {
            game.checkBattleState();
        });
        Assertions.assertEquals("Wrong State", error19.getMessage());
        AssertionError error20 = Assertions.assertThrows(AssertionError.class, () -> {
            game.increaseScore();
        });
        Assertions.assertEquals("Wrong State", error20.getMessage());
        AssertionError error21 = Assertions.assertThrows(AssertionError.class, () -> {
            game.getBattle();
        });
        Assertions.assertEquals("Wrong State", error21.getMessage());
        AssertionError error22 = Assertions.assertThrows(AssertionError.class, () -> {
            game.getCharacters();
        });
        Assertions.assertEquals("Wrong State", error22.getMessage());
    }
    @Test
    public void testBattle(){
        Random random = new Random();
        random.setSeed(2);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        assertTrue(game.isInBattle());
        game.setSeed(2);
        game.addRandomEnemy(1);
        game.addRandomEnemy(1);
        game.addRandomEnemy(1);
        game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
        game.marcosHammerAttack();
        game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(1));
        game.luigiHammerAttack();
        game.normalAttack();
        game.normalAttack();
        game.normalAttack();
        game.chooseItem("RedMushroom");
        game.choosePlayer(game.getLuigi());
    }
    @Test
    public void testWin(){
        Random random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.getBattle().getEnemies().size()>0){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.getBattle().getEnemies().size()>0) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.getBattle().getEnemies().size()>0) {
                game.normalAttack();
            }
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(1,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.getBattle().getEnemies().size()>0){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.getBattle().getEnemies().size()>0) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.getBattle().getEnemies().size()>0) {
                game.normalAttack();
            }
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(2,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.getBattle().getEnemies().size()>0){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.getBattle().getEnemies().size()>0) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.getBattle().getEnemies().size()>0) {
                game.normalAttack();
            }
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(3,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.getBattle().getEnemies().size()>0){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.getBattle().getEnemies().size()>0) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.getBattle().getEnemies().size()>0) {
                game.normalAttack();
            }
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(4,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.getBattle().getEnemies().size()>0){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.getBattle().getEnemies().size()>0) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.getBattle().getEnemies().size()>0) {
                game.normalAttack();
            }
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(5,this.game.getScore());
        assertTrue(game.getState().hasWon());

    }
    @Test
    public void testLoss(){
        Random random = new Random();
        random.setSeed(3);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getBattle().setSeed(3);
        game.addRandomEnemy(1);
        while(game.getBattle().getLuigi().isAlive()){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
            game.luigiJumpAttack();
            game.normalAttack();
        }
        while(game.getBattle().getMarcos().isAlive()){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            game.normalAttack();
        }
        assertTrue(this.game.getBattle().isOver());
        game.checkBattleState();
        assertEquals(0,this.game.getScore());
        assertTrue(this.game.getState().isOver());
    }
}
