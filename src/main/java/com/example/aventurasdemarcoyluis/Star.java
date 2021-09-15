package com.example.aventurasdemarcoyluis;

public class Star implements Item{
    @Override
    public void effect(Protagonist protagonist) {
        protagonist.invincible();
    }
}
