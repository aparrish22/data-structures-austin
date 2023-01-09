package java_austin.SimpleHashTable;

import java.util.LinkedList;

// simple hash table that takes in integers
// collisions solved with Separate Chaining
public class SimpleHashTable<K, V> {
    
    private LinkedList[] data;
    private int size;

    public SimpleHashTable(int size) {
        data = new LinkedList[size];
        this.size = size;
    }

    public boolean put(K key, V value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        Pair<K,V> dataPair = new Pair<>(key,value);
        
        LinkedList list = data[index];
        return list.add(dataPair);
        
    }

    private int getHashCode(K key) {
        return (int)key;
    }

    private int convertToIndex(int hashCode) {
        return hashCode % size;
    }

}
