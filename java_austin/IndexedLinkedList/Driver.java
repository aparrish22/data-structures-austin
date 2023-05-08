package java_austin.IndexedLinkedList;

import java.lang.Math;
import java.util.HashSet;

public class Driver {
    public static void main(String[] args) {
        
        IndexedLinkedList myLinkedList = new IndexedLinkedList<>();



    }
}


class Character {

    private final String NAME;
    private final int ID;
    private int level;
    // TODO create more variables

    // testing randomizing ID
    // inside constructor
    public Character(String name) {
        this.name = name;
        this.ID = Math.floor(Math.random() * 10);
        this.level = 1;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public void levelUp() {
        if (level <= 20)
            level += 1;
        else
            break;
    }



}