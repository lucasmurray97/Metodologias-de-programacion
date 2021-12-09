package com.example.aventurasdemarcoyluis.model.Battle;

import com.example.aventurasdemarcoyluis.model.BagPack;
import com.example.aventurasdemarcoyluis.model.Battle.BattleStates.BattleState;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Enemies.Enemy;
import com.example.aventurasdemarcoyluis.model.Characters.Players.*;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidGamePlay;
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

    void chooseTargetLuigi(AttackableByLuigi enemy) throws InvalidGamePlay;

    void chooseTargetMarcos(AttackableByMarcos enemy) throws InvalidGamePlay;

    void chooseItem(String str) throws InvalidGamePlay;

    void choosePlayer(Player aPlayer) throws InvalidGamePlay;

    void setSeed(int n);

    ArrayList<Player> getPlayers();

    boolean isLuigisTurn();

    boolean isMarcosTurn();

    void terminate() throws InvalidGamePlay;

    boolean isEnemyTurn();

    ArrayList<Enemy> getEnemies();

    void checkSurvivors();

    Luigi getLuigi();

    Marcos getMarcos();

    void marcosJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    void luigiJumpAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    void normalAttack() throws InvalidGamePlay;

    void marcosHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    void luigiHammerAttack() throws InvalidCharacterActionException, InvalidGamePlay;

    boolean isBooTurn();

    boolean isGoombaTurn();

    boolean isSpinyTurn();

    boolean isPlayerTurn();

    void addEnemy(Enemy anEnemy);

    void addPlayer(Player aPlayer);

    void addMarcos(Marcos aMarcos);

    void addLuigi(Luigi aLuigi);

    void addRandomEnemy(int level);

    void addRandomEnemy(int level, int hp, int atk, int def);

    Character getNextCharacter();
}
