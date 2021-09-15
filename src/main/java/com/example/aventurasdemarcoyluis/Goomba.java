package com.example.aventurasdemarcoyluis;

public class Goomba extends AbstractCharacter implements Enemies {
    private String type = "Goomba";

    public Goomba(int lvl) {
        super(lvl, "Goomba", 100, 100, 100);
    }

}
