package java_austin.IndexedLinkedList;

import java.lang.Math;
import java.util.HashSet;

public class Driver {
    public static void main(String[] args) {
        
        IndexedLinkedList<Character> myLinkedList = new IndexedLinkedList<Character>();

        Character char1 = new Character("Beric");
        Character char2 = new Character("Drah");
        Character char3 = new Character("Miles");

        myLinkedList.add(char1);
        myLinkedList.add(char2);
        myLinkedList.add(char3);

        System.out.println("My LinkedList's size is: " + myLinkedList.listSize());
        myLinkedList.removeIndex(0);
        System.out.println("My LinkedList's size is: " + myLinkedList.listSize());
        

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
        this.NAME = name;
        this.ID = (int) Math.random() * 10;
        this.level = 1;
    }

    public String getName() {
        return this.NAME;
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