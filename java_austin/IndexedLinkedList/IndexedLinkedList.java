package java_austin.IndexedLinkedList;

import java.util.Iterator;

/*
 * TODO
 * 
 * JUnit Testing my Implementation of isLL with Java
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
public class IndexedLinkedList<T> implements IndexedList<T>, Iterable<T> {

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
        tail = head;
        size = 0;
    }

    // helper
    // if index exists in list, then the list is not empty
    private void checkIndexBounds(int index) {
        try {
            if (index < 0 || index >= listSize())
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You entered an index outside of" 
                + " list's bounds. " + e);
        }
    }

    // helper method
    // O(n) 
    // return node at given index
    private IndexedLNode<T> findIndexedLNode(int index) {

        checkIndexBounds(index); // throws error if out of bounds

        IndexedLNode<T> current = head;

        while (current.getNext() != null) {
            if (index == current.getIndex()) {
                return current;
            } else {
                current = current.getNext();
            }
        }

        return head;
    }

    // O(n) append to list
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

    // O(1)
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

    // O(n)
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

    // return the object at particular position/index 
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
        
        IndexedLNode<T> current = new IndexedLNode<>();
        current = head;
        
        if (head != null) {
            if (head.getData() == element) {
                return head.getIndex();
            } else {
                while (current.getNext() != null) {
                    current = current.getNext();
                    if (current.getData() == element)
                        return current.getIndex();
                }
            }
        } 
        
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) 
            return true;
        return false;
    }

    public IndexedLNode<T> getHead() { return head; }

    public IndexedLNode<T> getTail() { return tail; }
    
    @Override
    public Iterator<T> iterator() {
        return new IndexedLinkedListIterator<T>(this);
    }

    // O(n) linear search, removal, & re-index (3n)
    // remove node with given element
    // throw error that cannot be found
    @Override
    public void removeElement(T element) {
        
        IndexedLNode<T> prevNode = new IndexedLNode<>();
        IndexedLNode<T> current = new IndexedLNode<>();
        IndexedLNode<T> nextNode = new IndexedLNode<>();

        int prevNodeIndex = 0;
        int currentNodeIndex = prevNodeIndex + 1;

        boolean found = this.contains(element);
    
        if (found) {
            // remove head
            if (listSize() != 0 && head != null) {
                if (head.getData() == element) {
                    head = null;
                    size--;
                }
            } else if (listSize() == 2 && tail != null) { 
                // if only two nodes (head & tail)
                // check tail
                if (tail.getData() == element) {
                    head.setLink(null); // tail is no longer referenced
                    size--;
                }
            } else { // at least 3 in list
                // we already checked head -> move on
                prevNode = head;
                current = head.getNext(); 
                nextNode = current.getNext();
                
                // iterate through list
                // relink once found
                // will run at least once 
                while (current.getNext() != null) { 
                    nextNode = current.getNext();
                    if (current.getData() == element) {
                        prevNodeIndex = prevNode.getIndex();
                        prevNode.setLink(nextNode);
                        // current node is removed
                        // re index
                        currentNodeIndex = prevNodeIndex + 1; // save index
                        current = nextNode;
                        current.setIndex(currentNodeIndex);
                        size--;
                        break;
                    } else {
                        prevNode = prevNode.getNext();
                        current = current.getNext();
                    }
                }

                // re-index, starting with nextNode
                // can be refactored
                while (current.getNext() != null) {
                    current.setIndex(currentNodeIndex);
                    currentNodeIndex++;
                    current = current.getNext();
                    current.setIndex(currentNodeIndex);
                }

            }
        } else {
            try {
                throw new Exception("Element not found in list. ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        

    }

    // O(1)
    // decrement size
    @Override
    public void removeIndex(int index) {
        // relink nodes. java trash collection 
        // will handle unreferenced node
        
        IndexedLNode<T> prevNode = new IndexedLNode<>();
        IndexedLNode<T> current = new IndexedLNode<>();
        IndexedLNode<T> nextNode = new IndexedLNode<>();

        int nextNodeIndex;
        int currentNodeIndex;
        int prevNodeIndex;
        int tailIndex = tail.getIndex();

        checkIndexBounds(index);

        // if one node in list (the head)
        if (listSize() == 1 && head != null && index == head.getIndex()) {
            head = null;
            size--;
        } else if (index == tailIndex) { // remove tail
            prevNodeIndex = tailIndex - 1;
            prevNode = findIndexedLNode(prevNodeIndex);
            prevNode.setLink(null);
            size--;
        } else if (index == head.getIndex()) { // remove head
        
        } else { // somewhere in list
            prevNodeIndex = index - 1;
            nextNodeIndex = index + 1;
            currentNodeIndex = index;
            prevNode = findIndexedLNode(prevNodeIndex);
            current = findIndexedLNode(index);
            nextNode = findIndexedLNode(nextNodeIndex);
            
            // relink
            prevNode.setLink(nextNode);
            current.setLink(null);

            // re-index 
            current = prevNode;
            current = current.getNext();
            current.setIndex(index);
            currentNodeIndex = current.getIndex();
            while (current.getNext() != null) {
                current = current.getNext();
                current.setIndex(currentNodeIndex);
                currentNodeIndex++;
            }
            // decrement size of list by one
            size--;

        }

    }

    // O(1)
    // grabs/returns element from node and replaces it
    @Override
    public T replace(int index, T element) {
        IndexedLNode<T> current = findIndexedLNode(index);
        T oldElement = current.getData();
        current.setData(element);
        return oldElement;
    }

    @Override
    public int listSize() {
        return size;
    }

    

    
    

}
