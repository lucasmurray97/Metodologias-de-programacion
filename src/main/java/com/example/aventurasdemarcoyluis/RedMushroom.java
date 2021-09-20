package com.example.aventurasdemarcoyluis;

/**
 * The type Red mushroom.
 */
public class RedMushroom extends AbstractItem implements Item{
    public RedMushroom() {
        super("RedMushroom");
    }

    /**
     * Instantiates a new Boo.
     *
     * @param aPlayer the lvl
     */
    @Override
    public void effect(Player aPlayer) {
        int newHp = (int) (1.1*aPlayer.getHp());
        aPlayer.setHp(newHp);
    }
}
