package com.example.aventurasdemarcoyluis.Game;

import com.example.aventurasdemarcoyluis.BagPack;
import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Players.*;
import com.example.aventurasdemarcoyluis.Game.Battle.Battle;
import com.example.aventurasdemarcoyluis.Game.GameStates.GameState;
import com.example.aventurasdemarcoyluis.Game.GameStates.PreparingBattle;

import java.util.ArrayList;

public class Game {
    private BagPack bag;
    private GameState state;
    private Luigi luigi;
    private Marcos marcos;
    int score;
    public Game(){
        this.score = 0;
        this.luigi = new Luigi(1);
        this.marcos = new Marcos(1);
        this.bag = new BagPack();
        this.luigi.setBag(this.bag);
        this.marcos.setBag(this.bag);
        this.setState(new PreparingBattle());
    }

    public void setState(GameState state) {
        this.state = state;
        this.state.setGame(this);
    }
    public void setScore(int points) {
        this.score = points;
    }
    public int getScore(){
        return this.score;
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
    }

    public void createBattle(int i) {
        this.state.createBattle(i);
    }
    public void createBattle() {
        this.state.createBattle();
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
    public Character getNextPlayer(){
        return this.state.getNextCharacter();
    }
    public void checkBattleState(){
        this.state.checkBattleState();
    }
    public void addRandomEnemy(int level){
        this.state.addRandomEnemy(level);
    }
    public void setSeed(int i) {
        this.getBattle().setSeed(i);
    }

    public void marcosHammerAttack() {
        this.state.marcosHammerAttack();
    }
    public void luigiHammerAttack() {
        this.state.luigiHammerAttack();
    }

    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }
    public void choosePlayer(Player aPlayer){
        this.state.choosePlayer(aPlayer);
    }

    public void terminate() {
        this.state.terminate();
    }

    public void levelUp() {
        this.state.levelUp();
    }

    public void increaseScore() {
        this.state.increaseScore();
    }

    public boolean isInBattle() {
        return this.state.isInBattle();
    }
}
