package com.example.aventurasdemarcoyluis.Items;

import java.util.Objects;

/**
 * The type Abstract item, describes the behavior of general items.
 */
public abstract class AbstractItem implements Item {
    private String name;

    /**
     * Instantiates a new Abstract item.
     *
     * @param aName the name of the item
     */
    public AbstractItem(String aName){
        this.name = aName;
    }

    /**
     * Gets the items name
     * @return the item's name
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Determines whether two items are equal, which is the case if they share their name.
     * @param o other item
     * @return if they are or not the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item anItem = (Item) o;
        return this.name.equals(anItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
