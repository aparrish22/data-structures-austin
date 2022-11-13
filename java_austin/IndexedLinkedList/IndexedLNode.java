package java_austin.IndexedLinkedList;

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

    @Override
    public IndexedLNode<T> getNext() {
        return next;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}