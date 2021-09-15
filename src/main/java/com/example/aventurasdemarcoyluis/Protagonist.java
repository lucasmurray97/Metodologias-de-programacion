package com.example.aventurasdemarcoyluis;

public abstract class Protagonist extends AbstractCharacter implements Player {
    private int fp;
    public Protagonist(int lvl, String type, int baseHp, int baseAtk, int baseDef) {
        super(lvl, type, baseHp, baseAtk, baseDef);
        this.fp = 0;
    }

    public void pickItem(Item anItem) {
        anItem.effect(this);
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }
    public void invincible() {
    }
}
