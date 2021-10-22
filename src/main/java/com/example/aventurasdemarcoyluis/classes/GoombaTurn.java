package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.AttackableByGoomba;
import com.example.aventurasdemarcoyluis.interfaces.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.interfaces.Player;

public class GoombaTurn extends EnemyTurn{
    @Override
    public boolean isGoombaTurn(){
        return true;
    }
    @Override
    public void normalAttack(){
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Goomba) this.getCurrentCharacter()).normalAttack((AttackableByGoomba) toBeattacked);
        pass();
    }
}
