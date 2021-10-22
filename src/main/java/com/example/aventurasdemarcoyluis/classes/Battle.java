package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.*;
import com.example.aventurasdemarcoyluis.interfaces.Character;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private ArrayList<Character> characters;
    private BagPack bag;
    private BattleState state;
    private Luigi luigi;
    private Marcos marcos;
    private ArrayList<Enemy> enemies;
    private ArrayList<Player> players;
    private Random random;
    private Character currentPlayer;

    public Battle(int randomEnemies, BagPack aBag, Luigi luigi, Marcos marcos) {
        this.bag = aBag;
        this.luigi = luigi;
        this.marcos = marcos;
        this.random = new Random();
        this.enemies = new ArrayList<Enemy>();
        this.players = new ArrayList<Player>();
        this.characters = new ArrayList<Character>();
        this.players.add(marcos);
        this.players.add(luigi);
        this.characters.add(marcos);
        this.characters.add(luigi);
        for(int i=0; i<randomEnemies; i++){
            int randomNumber = random.nextInt(3);
            if (randomNumber == 0){
                enemies.add(new Goomba(1));
                characters.add(new Goomba(1));
            }else if(randomNumber == 1){
                enemies.add(new Boo(1));
                characters.add(new Boo(1));
            }else{
                enemies.add(new Spiny(1));
                characters.add(new Spiny(1));
            }
        }
        this.setState(new MarcosTurn());
        this.setCurrentCharacter(marcos);
    }


    public void setState(BattleState aState) {
        this.state = aState;
        this.state.setBattle(this);
    }

    public BattleState getState() {
        return this.state;
    }

    public ArrayList<Character> getCharacters() {
        return this.characters;
    }
    public void addCharacter(Character aCharacter){
        characters.add(aCharacter);
    }

    public BagPack getBagPack() {
        return this.bag;
    }

    public boolean isOver() {
        return this.state.isOver();
    }

    public int getOutcome() {
        return 0;
    }

    public Character getCurrentPlayer() {
        return this.currentPlayer;
    }
    public void setCurrentCharacter(Character aCharacter) {
        this.currentPlayer = aCharacter ;
        this.state.setCurrentCharacter(aCharacter);
    }


    public void chooseAttack(String str) {
        this.state.chooseAttack(str);
    }

    public void chooseTargetLuigi(AttackableByLuigi enemy) {
        this.state.chooseTargetLuigi(enemy);
    }
    public void chooseTargetMarcos(AttackableByMarcos enemy) {
        this.state.chooseTargetMarcos(enemy);
    }
    public void executeTurn() {
        this.state.enemyAttack();
    }

    public void chooseItem(String str) {
        this.state.chooseItem(str);
    }

    public void choosePlayer(Player aPlayer) {
        this.state.choosePlayer(aPlayer);
    }

    public void setSeed() {
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public boolean isLuigisTurn() {
        return this.state.isLuigisTurn();
    }

    public boolean isMarcosTurn() {
        return this.state.isMarcosTurn();
    }

    public void pass() {
        this.state.pass();
    }

    public boolean isEnemyTurn() {
        return this.state.isEnemyTurn();
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }
    public void checkSurvivors(){
        for (Enemy enemy: this.getEnemies()) {
            if (enemy.isKnockedOut()) {
                this.getEnemies().remove(enemy);
                this.getCharacters().remove(enemy);
            }
        }
        for (Player player: this.getPlayers()) {
            if (player.isKnockedOut()) {
                this.getEnemies().remove(player);
                this.getCharacters().remove(player);
            }
        }
    }
    public Luigi getLuigi(){
        return this.luigi;
    }
    public Marcos getMarcos(){
        return this.marcos;
    }

    public void marcosJumpAttack() {
        this.state.marcosJumpAttack();
    }

    public void luigiJumpAttack() {
        this.state.luigiJumpAttack();
    }

    public void normalAttack() {
        this.state.normalAttack();
    }

    public void randomAttack() {
        this.state.randomAttack();
    }
}


