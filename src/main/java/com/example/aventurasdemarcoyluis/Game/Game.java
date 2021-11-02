package com.example.aventurasdemarcoyluis.Game;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Characters.Players.Luigi;
import com.example.aventurasdemarcoyluis.Characters.Players.Marcos;
import com.example.aventurasdemarcoyluis.Game.Battle.Battle;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;

import java.util.ArrayList;

public class Game {
    private BagPack bag;
    private GameState state;
    private Luigi luigi;
    private Marcos marcos;
    public Game(){
        this.luigi = new Luigi(1);
        this.marcos = new Marcos(1);
        this.bag = new BagPack();
        this.setState(new PreparingBattle());
    }

    public void setState(GameState state) {
        this.state = state;
        this.state.setGame(this);
    }

    public Luigi getLuigi() {
        return this.luigi;
    }

    public Marcos getMarcos() {
        return this.marcos;
    }

    public BagPack getBagPack() {
        return this.bag;
    }

    public GameState getState() {
        return this.state;
    }

    public void addRedMushroom(int i) {
        this.state.addRedMushroom(i);
    }

    public void addHoneySyrup(int i) {
        this.state.addHoneySyrup(i);
        while(i>=0) {
            this.getBagPack().addItem(new HoneySyrup());
            i--;
        }
    }

    public void createBattle(int i) {
        this.state.createBattle(i);
    }
    public Battle getBattle(){
        return this.state.getBattle();
    }

    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
    }

    public void marcosJumpAttack() {
        this.state.marcosJumpAttack();
    }

    public void normalAttack() {
        this.state.normalAttack();
    }

    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.state.chooseTargetLuigi(enemy);
    }

    public void luigiJumpAttack() {
        this.state.luigiJumpAttack();
    }
    public ArrayList<Character> getCharacters(){
        return this.state.getCharacters();
    }
    public Character getCurrentPlayer(){
        return this.state.getCurrentPlayer();
    }
}
