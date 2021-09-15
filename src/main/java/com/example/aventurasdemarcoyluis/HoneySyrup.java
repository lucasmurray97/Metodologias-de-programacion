package com.example.aventurasdemarcoyluis;

public class HoneySyrup implements Item{
    @Override
    public void effect(Protagonist protagonist) {
        int newFp = protagonist.getFp() + 3;
        protagonist.setHp(newFp);
    }
}
