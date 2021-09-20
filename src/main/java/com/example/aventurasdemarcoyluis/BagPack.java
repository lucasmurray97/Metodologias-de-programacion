package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BagPack {
    private HashMap<String, ArrayList<Item>> bag;
    private Player player;
    public BagPack(Player aPlayer){
        this.bag = new HashMap<String, ArrayList<Item>>();
        this.player = aPlayer;
    }
    public void pickItem(Item anItem){
        String name = anItem.getName();
        if(!bag.containsKey(name)){
            ArrayList<Item> itemList = new ArrayList<Item>();
            bag.put(name, itemList);
        }
        bag.get(name).add(anItem);
    }

    public void useItem(String anItem){
        if ((bag.containsKey(anItem))&&(bag.get(anItem).size()>0)) {
            Item item = bag.get(anItem).get(0);
            item.effect(this.player);
            bag.get(anItem).remove(0);
        }
    }

    public int getQuantity(String aItem){
        if (bag.containsKey(aItem)){
            return bag.get(aItem).size();
        }else{
            return 0;
        }
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BagPack)) return false;
        BagPack aBagpack = (BagPack) o;
        return this.player.equals(aBagpack.getPlayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
