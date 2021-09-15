package com.example.aventurasdemarcoyluis;

public class RedMushroom implements Item{
    @Override
    public void effect(Protagonist protagonist) {
        int newHp = (int) 1.1*protagonist.getHp();
        protagonist.setHp(newHp);
    }
}
