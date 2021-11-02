package com.example.aventurasdemarcoyluis.Game;

import com.example.aventurasdemarcoyluis.Characters.Character;
import com.example.aventurasdemarcoyluis.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.Game.Battle.Battle;

import java.util.ArrayList;

public class InBattle extends GameState{
    private Battle battle;
    @Override
    public boolean isInBattle() {
        return true;
    }
    @Override
    public void setBattle(Battle battle){
        this.battle = battle;
    }
    @Override
    public Battle getBattle(){
        return this.battle;
    }
    @Override
    public void chooseTargetMarcos(AttackableByMarcos enemy){
        this.battle.chooseTargetMarcos(enemy);
    }
    @Override
    public void chooseTargetLuigi(AttackableByLuigi enemy){
        this.battle.chooseTargetLuigi(enemy);
    }
    @Override
    public void marcosJumpAttack(){
        this.battle.marcosJumpAttack();
    }
    @Override
    public void luigiJumpAttack(){
        this.battle.luigiJumpAttack();
    }
    @Override
    public void normalAttack(){
        this.battle.getState().setEnemyTurn();
        this.battle.normalAttack();
    }
    @Override
    public void chooseItem(String str) {
        this.battle.chooseItem(str);
    }
    @Override
    public void pass() {
        this.battle.pass();
    }
    @Override
    public ArrayList<Character> getCharacters(){
        return this.battle.getCharacters();
    }
    @Override
    public Character getCurrentPlayer() {
        return battle.getCurrentPlayer();
    }
    @Override
    public Character getNextCharacter() {
        return battle.getNextCharacter();
    }
}
