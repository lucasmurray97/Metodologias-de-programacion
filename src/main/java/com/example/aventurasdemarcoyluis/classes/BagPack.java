package com.example.aventurasdemarcoyluis.classes;

import com.example.aventurasdemarcoyluis.interfaces.Item;
import com.example.aventurasdemarcoyluis.interfaces.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Represents the bagpack of a Player, that stores items.
 */
public class BagPack {
    private HashMap<String, ArrayList<Item>> bag;
    private Player player;

    /**
     * Instantiates a new Bag pack. Uses a hashmap to store the different items, where an item has an Arraylist if
     * it's own in the hashmap, and items of that type are appended to it.
     *
     * @param aPlayer the player that owns the bagpack.
     */
    public BagPack(Player aPlayer){
        this.bag = new HashMap<String, ArrayList<Item>>();
        this.player = aPlayer;
    }

    /**
     * Picks item. If items of that type are in the bag, the item is added to the arraylist. If not, an array list
     * of that item's type is created and the item added.
     *
     * @param anItem Item that is picked
     */
    public void pickItem(Item anItem){
        String name = anItem.getName();
        if(!bag.containsKey(name)){
            ArrayList<Item> itemList = new ArrayList<Item>();
            bag.put(name, itemList);
        }
        bag.get(name).add(anItem);
    }

    /**
     * Uses item. In case there are items of anItems' type in the bag, they are used, and the corresponding arraylist
     * is reduced by one of it's items.
     *
     * @param anItem the an item
     */
    public void useItem(String anItem){
        if ((bag.containsKey(anItem))&&(bag.get(anItem).size()>0)) {
            Item item = bag.get(anItem).get(0);
            item.effect(this.player);
            bag.get(anItem).remove(0);
        }
    }

    /**
     * Gets quantity of items of type aItem in the bag.
     *
     * @param aItem the a item
     * @return the int
     */
    public int getQuantity(String aItem){
        if (bag.containsKey(aItem)){
            return bag.get(aItem).size();
        }else{
            return 0;
        }
    }

    /**
     * Gets player, the owner of the bag.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Determines whether two bagpacks are the same, which is the case if they have the same owner.
     * @param o other bagpah
     * @return boolean
     */
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

    @Override
    public String toString() {
        String stringio = "" + player.getType() +"'s BagPack, it contains:";
        for ( String anItem: bag.keySet())
              {stringio += " " + bag.get(anItem).size()+" " + anItem+ "s,";

        }

        return stringio.substring(0,stringio.length()-1);
    }
}
