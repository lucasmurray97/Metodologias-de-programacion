package com.example.aventurasdemarcoyluis.model.Battle;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.BattleOverHandler;

import java.util.ArrayList;
import java.util.Random;

public class NullBattle implements IBattle{
    @Override
    public void setNextCharacter(Character aCharacter) {

    }

    @Override
    public Random getRandom() {
        return null;
    }

    @Override
    public void setRandom(Random random) {

    }

    @Override
    public void addObserver(BattleOverHandler resp) {

    }

    @Override
    public void setOutcome(int outcome) {

    }

    @Override
    public void setState(BattleState aState) {

    }

    @Override
    public BattleState getState() {
        return null;
    }

    @Override
    public ArrayList<Character> getCharacters() {
        return null;
    }

    @Override
    public void addCharacter(Character aCharacter) {

    }

    @Override
    public BagPack getBagPack() {
        return null;
    }

    @Override
    public void setBagPack(BagPack aBag) {

    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public int getOutcome() {
        return 0;
    }

    @Override
    public Character getCurrentPlayer() {
        return null;
    }

    @Override
    public void setCurrentCharacter(Character aCharacter) {

    }

    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy) {

    }

    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy) {

    }

    @Override
    public void chooseItem(String str) {

    }

    @Override
    public void choosePlayer(Player aPlayer) {

    }

    @Override
    public void setSeed(int n) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public boolean isLuigisTurn() {
        return false;
    }

    @Override
    public boolean isMarcosTurn() {
        return false;
    }

    @Override
    public void terminate() {

    }

    @Override
    public boolean isEnemyTurn() {
        return false;
    }

    @Override
    public ArrayList<Enemy> getEnemies() {
        return null;
    }

    @Override
    public void checkSurvivors() {

    }

    @Override
    public Luigi getLuigi() {
        return null;
    }

    @Override
    public Marcos getMarcos() {
        return null;
    }

    @Override
    public void marcosJumpAttack() {

    }

    @Override
    public void luigiJumpAttack() {

    }

    @Override
    public void normalAttack() {

    }

    @Override
    public void marcosHammerAttack() {

    }

    @Override
    public void luigiHammerAttack() {

    }

    @Override
    public boolean isBooTurn() {
        return false;
    }

    @Override
    public boolean isGoombaTurn() {
        return false;
    }

    @Override
    public boolean isSpinyTurn() {
        return false;
    }

    @Override
    public boolean isPlayerTurn() {
        return false;
    }

    @Override
    public void addEnemy(Enemy anEnemy) {

    }

    @Override
    public void addPlayer(Player aPlayer) {

    }

    @Override
    public void addMarcos(Marcos aMarcos) {

    }

    @Override
    public void addLuigi(Luigi aLuigi) {

    }

    @Override
    public void addRandomEnemy(int level) {

    }

    @Override
    public void addRandomEnemy(int level, int hp, int atk, int def) {

    }

    @Override
    public Character getNextCharacter() {
        return null;
    }
}
