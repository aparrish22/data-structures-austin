package java_austin.IndexedLinkedList;

public class LNode<T> extends Node<T> {
    
    private LNode<T> next;

    public LNode() {
        setData(null);
        next = null;
    }

    public LNode(T data, LNode<T> node) {
        setData(data);
        next = node;
    }

    public LNode<T> getNext() {
        return next;
    }
    
    public void setLink(LNode<T> node) {
        this.next = node;
    }

}
