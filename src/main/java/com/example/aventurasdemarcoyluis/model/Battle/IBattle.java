package com.example.aventurasdemarcoyluis.model.Battle;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Handlers.BattleOverHandler;

import java.util.ArrayList;
import java.util.Random;

public interface IBattle {
    void setNextCharacter(Character aCharacter);

    Random getRandom();

    void setRandom(Random random);

    void addObserver(BattleOverHandler resp);

    void setOutcome(int outcome);

    void setState(BattleState aState);

    BattleState getState();

    ArrayList<Character> getCharacters();

    void addCharacter(Character aCharacter);

    BagPack getBagPack();

    void setBagPack(BagPack aBag);

    boolean isOver();

    int getOutcome();

    Character getCurrentPlayer();

    void setCurrentCharacter(Character aCharacter);

    void chooseTargetLuigi(AttackableByLuigi enemy);

    void chooseTargetMarcos(AttackableByMarcos enemy);

    void chooseItem(String str);

    void choosePlayer(Player aPlayer);

    void setSeed(int n);

    ArrayList<Player> getPlayers();

    boolean isLuigisTurn();

    boolean isMarcosTurn();

    void terminate();

    boolean isEnemyTurn();

    ArrayList<Enemy> getEnemies();

    void checkSurvivors();

    Luigi getLuigi();

    Marcos getMarcos();

    void marcosJumpAttack() throws InvalidCharacterActionException;

    void luigiJumpAttack() throws InvalidCharacterActionException;

    void normalAttack();

    void marcosHammerAttack() throws InvalidCharacterActionException;

    void luigiHammerAttack() throws InvalidCharacterActionException;

    boolean isBooTurn();

    boolean isGoombaTurn();

    boolean isSpinyTurn();

    boolean isPlayerTurn();

    void addEnemy(Enemy anEnemy);

    void addPlayer(Player aPlayer);

    void addMarcos(Marcos aMarcos);

    void addLuigi(Luigi aLuigi);

    void addRandomEnemy(int level);

    Character getNextCharacter();
}
