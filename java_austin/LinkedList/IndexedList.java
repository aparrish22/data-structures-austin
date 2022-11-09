package java_austin.LinkedList;

import java.util.Iterator;

public interface IndexedList<T> {
    public void add(T element);
    public void removeElement(T element);
    public boolean contains(T element);
    public T find(T element);
    public boolean isEmpty();
    public int listSize();
    public Iterator<T> iterator();

    public void removeIndex(int index);
    public void addIndex(int index, T element);
    public int indexOf(T element);
    public T replace(int index, T element);
    public T get(int index);
}
