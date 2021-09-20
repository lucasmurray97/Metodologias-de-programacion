package com.example.aventurasdemarcoyluis;

/**
 * The type Red mushroom.
 */
public class RedMushroom extends AbstractItem implements Item{
    /**
     * Instantiates a new RedMushroom.
     */
    public RedMushroom() {
        super("RedMushroom");
    }

    /**
     * Increments Hp by 10%
     * @param aPlayer the player that uses the item.
     */
    @Override
    public void effect(Player aPlayer) {
        int newHp = (int) (1.1*aPlayer.getHp());
        aPlayer.setHp(newHp);
    }
}
