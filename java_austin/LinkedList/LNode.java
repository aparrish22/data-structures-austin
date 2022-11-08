package java_austin.LinkedList;

public class LNode<T> extends Node<T> {
    
    private LNode<T> pointer;

    public LNode(T data, LNode<T> node) {
        setData(data);
        node = pointer;
    }

    public LNode<T> getPointer() {
        return pointer;
    }
    
    public void setPointer(LNode<T> node) {
        this.pointer = node;
    }

}
