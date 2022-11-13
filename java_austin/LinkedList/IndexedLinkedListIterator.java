package java_austin.LinkedList;

import java.util.Iterator;

public class IndexedLinkedListIterator<T> implements Iterator<T> {

    private IndexedLNode<T> current;
    private IndexedLinkedList<T> list;

    public IndexedLinkedListIterator(IndexedLinkedList<T> list) {
        setList(list);
        try {
            current = list.getHead();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    // helpers
    private IndexedLinkedList<T> getList() { 
        return list; 
    }

    private void setList(IndexedLinkedList<T> list) {
        this.list = list;
    }
    // end of helpers

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    // return data and move to next pointer
    @Override
    public T next() {
        T element = null;
        if (this.hasNext()) {
            element = current.getData();
            current = current.getNext();
        }
        return element;
    }

    @Override
    public void remove() {
        IndexedLinkedList<T> theList = this.getList();
        IndexedLNode<T> tail = theList.getTail();
        theList.removeIndex(tail.getIndex());
    }

}
