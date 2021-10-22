package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.interfaces.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.interfaces.Character;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;
import com.example.aventurasdemarcoyluis.interfaces.Player;

public class BattleState {
    private com.example.aventurasdemarcoyluis.interfaces.Character currentCharacter;
    private Battle battle;
    public void setBattle(Battle aBattle) {
        this.battle = aBattle;
    }
    public Battle getBattle(){
        return this.battle;
    }
    public void changeState(BattleState aState){
        this.battle.setState(aState);
        this.battle.checkSurvivors();
    }
    public void setCurrentCharacter(Character aCharacter){
        this.currentCharacter = aCharacter;
    }
    public boolean isOver() {
        return false;
    }

    public boolean isMarcosTurn() {
        return false;
    }

    public boolean isLuigisTurn() {
        return false;
    }

    public boolean isEnemyTurn() {
        return false;
    }
    public boolean isPlayerTurn() {
        return false;
    }
    public boolean isBooTurn() {
        return false;
    }
    public boolean isGoombaTurn() {
        return false;
    }
    public boolean isSpinyTurn() {
        return false;
    }

    void error(){
        throw new AssertionError("Wrong State");
    }

    public void pass() {
        error();
    }

    public void chooseItem(String str) {
        error();
    }

    public void chooseAttack(String str) {
        error();
    }

    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        error();
    }

    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        error();
    }


    public void enemyAttack() {
        error();
    }

    public void choosePlayer(Player aPlayer) {
        error();
    }
    public boolean isLuigiAlive(){
        return this.battle.getPlayers().get(1).isAlive();
    }
    public boolean isMarcosAlive(){
        return this.battle.getPlayers().get(0).isAlive();
    }
    public boolean anyEnemiesAlive(){
        for (Enemy enemy: this.battle.getEnemies()) {
            if (enemy.isAlive()) {
                return true;
            }
        }
        return false;

    }
    public Character getCurrentCharacter(){
        return this.currentCharacter;
    }
    public void randomAttack(){
        error();
    }
    public void normalAttack() {
        error();
    }
    public void marcosJumpAttack(){
        error();
    }
    public void luigiJumpAttack(){
        error();
    }
    public void marcosHammerAttack(){
        error();
    }
    public void luigiHammerAttack(){
        error();
    }
}
