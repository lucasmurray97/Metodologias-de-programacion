package com.example.aventurasdemarcoyluis;

import java.util.Objects;

public abstract class AbstractItem implements Item {
    private String name;
    public AbstractItem(String aName){
        this.name = aName;
    }
    public String getName(){
        return this.name;
    }
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
}
