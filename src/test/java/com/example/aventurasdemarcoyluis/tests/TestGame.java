package com.example.aventurasdemarcoyluis.tests;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.Game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testBattle(){
        game.addRedMushroom(3);
        game.addHoneySyrup(3);
        game.createBattle(3);
        game.chooseTargetMarcos((AttackableByMarcos) game.getBattle().getEnemies().get(1));
        game.marcosJumpAttack();
        game.chooseTargetLuigi((AttackableByLuigi) game.getBattle().getEnemies().get(1));
        game.luigiJumpAttack();
        game.normalAttack();
    }
    @Test
    public void testWin(){

    }
    @Test
    public void testLoss(){

    }
}
