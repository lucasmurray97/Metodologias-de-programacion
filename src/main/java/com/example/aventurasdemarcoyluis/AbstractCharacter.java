package com.example.aventurasdemarcoyluis;
import java.lang.Math;

public abstract class AbstractCharacter {
    private int lvl;
    private int atk;
    private int def;
    private int hp;
    private int maxHp;
    private int maxAtk;
    private int maxDef;
    private String type;




    public AbstractCharacter(int lvl, String type, int baseHp, int baseAtk, int baseDef) {
        this.lvl = lvl;
        this.maxHp = (int) (baseHp*Math.pow(1.1,this.lvl));
        this.maxAtk = (int) (baseAtk*Math.pow(1.1,this.lvl));
        this.maxDef = (int) (baseDef*Math.pow(1.1,this.lvl));
        this.hp = this.maxHp;
        this.atk = this.maxAtk;
        this.def = this.maxDef;
        this.type = type;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }
}
