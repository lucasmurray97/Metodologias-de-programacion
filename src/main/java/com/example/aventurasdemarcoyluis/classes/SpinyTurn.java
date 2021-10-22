package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.AttackableBySpiny;
import com.example.aventurasdemarcoyluis.interfaces.Enemy;
import com.example.aventurasdemarcoyluis.interfaces.Player;

public class SpinyTurn extends EnemyTurn{
    @Override
    public boolean isSpinyTurn(){
        return true;
    }
    @Override
    public void normalAttack(){
        this.setCurrentCharacter(this.getCurrentCharacter());
        int n = this.getBattle().getPlayers().size();
        Player toBeattacked = this.getBattle().getPlayers().get(this.getRandom().nextInt(n));
        ((Spiny) this.getCurrentCharacter()).normalAttack((AttackableBySpiny) toBeattacked);
        pass();
    }
}
