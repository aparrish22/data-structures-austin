package java_austin.LinkedList;

public class LNode<T> extends Node<T> {
    
    private LNode<T> next;

    public LNode() {
        setData(null);
        next = null;
    }

    public LNode(T data, LNode<T> node) {
        setData(data);
        node = next;
    }

    public LNode<T> getNext() {
        return next;
    }
    
    public void setLink(LNode<T> node) {
        this.next = node;
    }

}
