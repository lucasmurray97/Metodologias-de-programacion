package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Boo;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.model.Battle.Battle;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import com.example.aventurasdemarcoyluis.model.Game.GameStates.GameState;
import com.example.aventurasdemarcoyluis.model.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.Items.Item;
import com.example.aventurasdemarcoyluis.model.Items.RedMushroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {
    private Game game;
    @BeforeEach
    public void setUp() {
        this.game = new Game("test");
    }
    @Test
    public void testGameSetUp(){
        Luigi luigi = this.game.getLuigi();
        Marcos marcos = this.game.getMarcos();
        BagPack bag = this.game.getBagPack();
        assertEquals(new Luigi(1).getType(), luigi.getType());
        assertEquals(new Marcos(1).getType(), marcos.getType());
        assertEquals(new BagPack(), bag);
        assertTrue(this.game.getState().isPreparingBattle());
    }
    @Test
    public void testGameSetUp2(){
        this.game = new Game();
        Luigi luigi = this.game.getLuigi();
        Marcos marcos = this.game.getMarcos();
        BagPack bag = this.game.getBagPack();
        assertEquals(new Luigi(1).getType(), luigi.getType());
        assertEquals(new Marcos(1).getType(), marcos.getType());
        assertEquals(new BagPack(), bag);
        assertTrue(this.game.getState().isPreparingBattle());
    }
    @Test
    public void generalFunctionalities(){
        this.game.setScore(2);
        assertEquals(2,this.game.getScore());
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        assertEquals(3, game.getBagPack().getQuantity("RedMushroom"));
        game.createBattle();
        game.setSeed(2);
        game.addRandomEnemy(1);
        game.addRandomEnemy(1);
        game.addRandomEnemy(1);
        ArrayList<Character> characters = new ArrayList<Character>();
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new HoneySyrup());
        items.add(new HoneySyrup());
        items.add(new HoneySyrup());
        items.add(new RedMushroom());
        items.add(new RedMushroom());
        items.add(new RedMushroom());
        assertEquals(game.getCurrentPlayer(),game.getMarcos());
        assertEquals(game.getNextPlayer(),game.getLuigi());
        assertEquals(5,game.getCharacters().size());
        assertEquals(items, game.getItems());
    }
    @Test
    public void gameStateTest(){
        game.setState(new GameState());
        assertEquals(game, game.getState().getGame());
        assertTrue(!game.getState().isPreparingBattle());
        assertTrue(!game.getState().isInBattle());
        assertTrue(!game.getState().Lost());
        assertTrue(!game.getState().hasWon());
        Throwable error = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().createBattle(1);
        });
        Assertions.assertEquals("You cannot create a battle now!", error.getMessage());
        Throwable error2 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().createBattle();
        });
        Assertions.assertEquals("You cannot create a battle now!", error2.getMessage());
        Throwable error3 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().addRandomEnemy(1);
        });
        Assertions.assertEquals("You cannot add an enemy now!", error3.getMessage());
        Throwable error4 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().addHoneySyrup(1);
        });
        Assertions.assertEquals("You cannot add an item now!", error4.getMessage());
        Throwable error5 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().addRedMushroom(1);
        });
        Assertions.assertEquals("You cannot add an item now!", error5.getMessage());
        Throwable error6 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().setBattle(new Battle());
        });
        Assertions.assertEquals("You cannot set the battle state now!", error6.getMessage());
        Throwable error7 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().chooseTargetMarcos(new Goomba(1));
        });
        Assertions.assertEquals("You cannot choose a target now!", error7.getMessage());
        Throwable error8 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().marcosJumpAttack();
        });
        Assertions.assertEquals("You cannot jump attack now!", error8.getMessage());
        Throwable error9 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().marcosHammerAttack();
        });
        Assertions.assertEquals("You cannot hammer attack now!", error9.getMessage());
        Throwable error10 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().luigiJumpAttack();
        });
        Assertions.assertEquals("You cannot jump attack now!", error10.getMessage());
        Throwable error11 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().luigiHammerAttack();
        });
        Assertions.assertEquals("You cannot hammer attack now!", error11.getMessage());
        Throwable error12 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().normalAttack();
        });
        Assertions.assertEquals("You cannot normal attack now!", error12.getMessage());
        Throwable error13 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().chooseTargetLuigi(new Goomba(1));
        });
        Assertions.assertEquals("You cannot choose a target now!", error13.getMessage());
        Throwable error14 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().chooseItem("RedMushroom");
        });
        Assertions.assertEquals("You cannot choose an item now!", error14.getMessage());
        Throwable error15 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().terminate();
        });
        Assertions.assertEquals("You cannot terminate the turn now!", error15.getMessage());
        Throwable error16 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().levelUp();
        });
        Assertions.assertEquals("You cannot increase the players levels now!", error16.getMessage());
        Throwable error17 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().getCurrentPlayer();
        });
        Assertions.assertEquals("You cannot get current player now!", error17.getMessage());
        Throwable error18 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().getNextCharacter();
        });
        Assertions.assertEquals("You cannot get next player now!", error18.getMessage());
        Throwable error20 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().increaseScore();
        });
        Assertions.assertEquals("You cannot increase score now!", error20.getMessage());
        Throwable error21 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().getBattle();
        });
        Assertions.assertEquals("There is no battle taking place!", error21.getMessage());
        Throwable error22 = Assertions.assertThrows(InvalidGamePlay.class, () -> {
            game.getState().getCharacters();
        });
        Assertions.assertEquals("You cannot get characters now!", error22.getMessage());
    }
    @Test
    public void battleSetUp(){
        game.getLuigi().setHp(0);
        game.getMarcos().setHp(0);
        game.createBattle(3);
        assertTrue(game.getLuigi().isAlive());
        assertTrue(game.getMarcos().isAlive());
        assertEquals(5,game.getCharacters().size());
    }
    @Test
    public void testBattle(){
        Random random = new Random();
        random.setSeed(2);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(10);
        game.getMarcos().setFp(10);
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
        game.getLuigi().setFp(300);
        game.getMarcos().setFp(300);
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.isInBattle()){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if(game.isInBattle()) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if(game.isInBattle()) {
                game.normalAttack();
            }
        }
        assertTrue(!this.game.isInBattle());
        assertEquals(1,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(300);
        game.getMarcos().setFp(300);
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.isInBattle()) {
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if (game.isInBattle()) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if (game.isInBattle()) {
                game.normalAttack();
            }
        }
        assertTrue(!this.game.isInBattle());
        assertEquals(2,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(300);
        game.getMarcos().setFp(300);
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.isInBattle()) {
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if (game.isInBattle()) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if (game.isInBattle()) {
                game.normalAttack();
            }
        }
        assertTrue(!this.game.isInBattle());
        assertEquals(3,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(300);
        game.getMarcos().setFp(300);
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.isInBattle()) {
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if (game.isInBattle()) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if (game.isInBattle()) {
                game.normalAttack();
            }
        }
        assertTrue(!this.game.isInBattle());
        assertEquals(4,this.game.getScore());
        random = new Random();
        random.setSeed(1);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(300);
        game.getMarcos().setFp(300);
        game.getBattle().setSeed(1);
        game.addRandomEnemy(1);
        while(game.isInBattle()) {
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            if (game.isInBattle()) {
                game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
                game.luigiJumpAttack();
            }
            if (game.isInBattle()) {
                game.normalAttack();
            }
        }
        assertTrue(game.hasWon());
        assertEquals(5,this.game.getScore());
    }
    @Test
    public void testLoss(){
        Random random = new Random();
        random.setSeed(3);
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle();
        game.getLuigi().setFp(50);
        game.getMarcos().setFp(50);
        game.getBattle().setSeed(3);
        game.addRandomEnemy(1);
        while(game.getBattle().getLuigi().isAlive()){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(0));
            game.luigiJumpAttack();
            game.normalAttack();
        }
        while(!game.Lost()){
            game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(0));
            game.marcosJumpAttack();
            game.normalAttack();
        }
        assertEquals(0,this.game.getScore());
        assertTrue(this.game.Lost());
    }
}
