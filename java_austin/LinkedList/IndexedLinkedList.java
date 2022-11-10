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
 * tail is referred to the last node in the list.
 */
public class IndexedLinkedList<T> implements IndexedList<T> {

    /*
     * diamond type generic <>, <T>, either or 
     */
    private IndexedLNode<T> head, tail;
    private int size;

    // empty LinkedList (node with no data)
    public IndexedLinkedList() {
        // new feature of java?? (like python)
        // next = null as param no compile error. new feat of java??
        head = new IndexedLNode<>();
        head.setLink(null); 
        size = 0;
    }

    // helper
    private void checkIndexBounds(int index) {
        try {
            if (index >= listSize() || index < 0)
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You entered an index outside of" 
                + " list's bounds. " + e);
        }
    }

    // helper method
    // O(n) 
    private IndexedLNode<T> findIndexedLNode(int index) {

        checkIndexBounds(index);

        IndexedLNode<T> current = head;

        while (current.getNext() != null) {
            if (index == current.getIndex()) {
                return current;
            } else {
                current = current.getNext();
            }
        }

        return head; //placeholder
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
            tail = head;
            size++;
        } else { // if head exists
            current = head;
            tail = current;
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
            tail = current;
            // insert data into newHead
            tail.setIndex(indexCount);
            tail.setData(element);
            tail.setLink(null);
        }
        
    }

    // insert new node with passed in element
    // insert node at index and relink nodes
    @Override
    public void addIndex(int index, T element) {
        
        checkIndexBounds(index);

        IndexedLNode<T> current = new IndexedLNode<>();
        IndexedLNode<T> prev = new IndexedLNode<>();
        IndexedLNode<T> next = new IndexedLNode<>();
        IndexedLNode<T> newNode = new IndexedLNode<>();


        int currentIndex  = 0;
        int headIndex = 0;
        int tailIndex = 0; 
        int prevNodeIndex;
        int nextNodeIndex;

        if (listSize() > 0) {
            tailIndex = listSize() - 1;
        }

        // if empty
        if (head == null && index == headIndex && this.listSize() == 0) {
            head.setIndex(index);
            head.setData(element);
            head.setLink(null);
            tail = head;
            size++;
        } else if (headIndex == index) {
            // if placed at head (beginning of list) 
            current = head;
            head.setLink(current);
            head.setData(element);
            head.setIndex(headIndex);
            current.setIndex(headIndex + 1);
        } else if (tailIndex == index && tail.getNext() == null) { 
            // if place at tail (end of list)
            prevNodeIndex = tailIndex - 1;
            current = findIndexedLNode(prevNodeIndex);
            current.setData(element);
            current.setLink(tail);
            tail.setIndex(tailIndex + 1);
            size++;
        } else {
            // if placed somewhere in the list
            
            // indices
            currentIndex = index;
            prevNodeIndex = index - 1;
            nextNodeIndex = index + 1;

            // nodes
            prev = findIndexedLNode(prevNodeIndex);
            current = findIndexedLNode(currentIndex);
            next = findIndexedLNode(nextNodeIndex);

            // insertion
            // current will be "pushed" forward
            newNode = current; // copy node
            newNode.setData(element);
            newNode.setIndex(index);
            
            // relink 
            prev.setLink(newNode);
            newNode.setLink(current);
            current.setLink(next);

            // update current's index
            currentIndex = index + 1;
            current.setIndex(currentIndex);

            // inc size of list, for new insertion, & update currentIndex
            size++;

            // loop and update indices of each node 
            while (current.getNext() != null && currentIndex < listSize()) {
                current = current.getNext();
                currentIndex++;
                current.setIndex(currentIndex);
            }
            
        }
            
        
    }

    // O(n)
    // traverse through LL
    @Override
    public boolean contains(T element) {
        
        IndexedLNode<T> current = new IndexedLNode<>();
        current = head;
        
        if (head != null) {
            if (head.getData() == element) {
                return true;
            } else {
                while (current.getNext() != null) {
                    current = current.getNext();
                    if (current.getData() == element)
                        return true;
                }
            }
        }
        return false;
    }

    // find and retrieve element
    @Override
    public T find(T element) {
        IndexedLNode<T> current = new IndexedLNode<>();
        current = head;
        
        if (head != null) {
            if (head.getData() == element) {
                return head.getData();
            } else {
                while (current.getNext() != null) {
                    current = current.getNext();
                    if (current.getData() == element)
                        return current.getData();
                }
            }
        } 

        return null;
    }

    // return the object at particular position 
    // by traversing the linked list in forward direction.
    // O(1)
    @Override
    public T get(int index) {
        return findIndexedLNode(index).getData();
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
