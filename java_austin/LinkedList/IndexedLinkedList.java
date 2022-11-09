package java_austin.LinkedList;

import java.util.Iterator;

/*
 * TODO-List
 * 
 * Unit Testing my Implementation of iLL with Java
 */

/*
 * Singly Linked List
 * "...singly linked lists include 
 * insertion, deletion and traversal."
 * by A.P.
 * 
 * notes by A.P :
 * The names 'element' and 'data' are used synonymously and interchangeably.
 * In the middle of implementing, I may have stumbled upon a feature similar 
 * to python's 'default arguments' when passing args/params.
 */
public class IndexedLinkedList<T> implements IndexedList<T> {

    /*
     * diamond type generic <>, <T>, either or 
     */
    private IndexedLNode<T> head, next;
    private int size;

    // empty LinkedList (node with no data)
    public IndexedLinkedList() {
        // new feature of java?? (like python)
        // next = null as param no compile error. new feat of java??
        head = new IndexedLNode<>();
        next = null;
        head.setLink(next); 
        size = 0;
    }

    // adds to where head points to
    @Override
    public void add(T element) {
        
        IndexedLNode<T> current = new IndexedLNode<>();
        int indexCount = 0;
    
        // if list is empty (we insert the first node)
        if (head == null) {
            head.setIndex(indexCount);
            head.setData(element);
            head.setLink(null);
            size++;
        } else { // if head exists
            current = head;
            indexCount++;
            size++;
            // iterate to the head, then insert
            // while link points to node
            while (current.getNext() != null) {
                current = current.getNext();
                indexCount++;
                size++;
            }

            // at the end of list (the head)
            head = current;
            // insert data into newHead
            head.setIndex(indexCount);
            head.setData(element);
            head.setLink(null);
        }
        
    }

    // insert new node with passed in element
    // insert node at index and relink nodes
    @Override
    public void addIndex(int index, T element) {
        
        IndexedLNode<T> current = new IndexedLNode<>();

        int currentIndex  = 0;
        int headIndex = 0;

        if (listSize() > 0) {
            headIndex = this.listSize() - 1;
        }

        // if empty
        if (head == null && index == currentIndex && this.listSize() == 0) {
            head.setIndex(index);
            head.setData(element);
            head.setLink(null);
            size++;
        } else if (headIndex == index && head.getNext() == null) { // if place at end of list
            // todo, cut the link prev of head
            
            // insert data into new location
            current = head;
            current.setData(element);
            current.setIndex(index);
            
            // insert new node after inserted node
            next = head;
            

        } else {
            
        }
            
        
    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    // find and retrieve element
    @Override
    public T find(T element) {
        // TODO Auto-generated method stub
        return null;
    }

    // return the object at particular position 
    // by traversing the linked list in forward direction.
    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    // return the position of data in linked list from root node 
    // if data present in linked list 
    // otherwise it will return -1
    @Override
    public int indexOf(T element) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeElement(T element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T replace(int index, T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int listSize() {
        return size;
    }

    

    
    

}
