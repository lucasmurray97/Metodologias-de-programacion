package com.example.aventurasdemarcoyluis;

import com.example.aventurasdemarcoyluis.Items.Item;
import com.example.aventurasdemarcoyluis.Characters.Players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Represents the bagpack of a Player, that stores items.
 */
public class BagPack {
    private HashMap<String, ArrayList<Item>> bag;

    /**
     * Instantiates a new Bag pack. Uses a hashmap to store the different items, where an item has an Arraylist if
     * it's own in the hashmap, and items of that type are appended to it.
     */
    public BagPack(){
        this.bag = new HashMap<String, ArrayList<Item>>();
    }

    /**
     * Picks item. If items of that type are in the bag, the item is added to the arraylist. If not, an array list
     * of that item's type is created and the item added.
     *
     * @param anItem Item that is picked
     */
    public void addItem(Item anItem){
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
     * @param anItem  the an item
     * @param aPlayer the a player
     */
    public void useItem(String anItem, Player aPlayer){
        if ((bag.containsKey(anItem))&&(bag.get(anItem).size()>0)) {
            Item item = bag.get(anItem).get(0);
            item.effect(aPlayer);
            bag.get(anItem).remove(0);
        }else{
            throw new AssertionError("Item not contained in bag");
        }
    }

    /**
     * Gets quantity of items of type aItem in the bag.
     *
     * @param anItem the a item
     * @return the int
     */
    public int getQuantity(String anItem){
        if (bag.containsKey(anItem)){
            return bag.get(anItem).size();
        }else{
            return 0;
        }
    }

    /**
     * Gets bag.
     *
     * @return the bag
     */
    public HashMap<String, ArrayList<Item>> getBag() {
        return bag;
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
        return this.bag.equals(aBagpack.getBag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bag);
    }

    @Override
    public String toString() {
        String stringio = "" +"This BagPack contains:";
        for ( String anItem: bag.keySet())
              {stringio += " " + bag.get(anItem).size()+" " + anItem+ "s,";

        }

        return stringio.substring(0,stringio.length()-1);
    }
}
