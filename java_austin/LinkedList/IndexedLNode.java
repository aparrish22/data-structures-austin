package java_austin.LinkedList;

public class IndexedLNode<T> extends LNode<T> {
    
    private int index;
    private IndexedLNode<T> next;
 
    public IndexedLNode() {
        super();
        this.index = -1;
    }
    
    public IndexedLNode(int index, T data, IndexedLNode<T> node) {
        super(data, node);
        setIndex(this.index);
    }

    // TODO find node at given index
    public IndexedLNode<T> findNode(int index) {
        return null;
    }
    
    @Override
    public IndexedLNode<T> getNext() {
        return next;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}