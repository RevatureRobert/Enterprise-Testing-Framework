package com.enterprise.util;


import javafx.util.Pair;
import java.util.Iterator;

public class HashMap<K,V> implements Iterable<Pair<K, V>>{

    private Node<K, V> buckets[];
    private int size;
    private int capacity;
    private int loadFactor;

    public HashMap() {
        capacity = 10;
        buckets = new Node[capacity];
        size = 0;
        loadFactor = 2;
    }

    public V put(K key, V value) {
        if (capacity / (size + 1) < loadFactor) {
            capacity = capacity * 2;
            Node<K, V> newBuckets[] = new Node[capacity];

            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] == null)
                    continue;

                Node<K, V> currentNode = buckets[i];

                while (currentNode != null) {
                    int index = getIndex(currentNode.key);
                    if (newBuckets[index] == null) {
                        newBuckets[index] = currentNode;
                        currentNode = currentNode.next;
                        newBuckets[index].next = null;
                    }
                    else {
                        Node<K, V> placeholder = currentNode;
                        currentNode = currentNode.next;
                        placeholder.next = newBuckets[index];
                        newBuckets[index] = placeholder;
                    }
                }
            }
            buckets = newBuckets;
        }

        int index = getIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Node<K, V>(key, value);
            size++;
            return value;
        }

        Node<K, V> currentNode = buckets[index];

        while (currentNode.next != null) {
            if (currentNode.key.equals(key))
                return null;
            currentNode = currentNode.next;
        }

        if (currentNode.key.equals(key))
            return null;

        currentNode.next = new Node<K, V>(key, value);
        size++;
        return value;
    }

    public V remove(K key) {
        int index = getIndex(key);
        if (buckets[index] == null)
            return null;

        Node<K, V> currentNode = buckets[index];

        if (currentNode.key.equals(key)) {
            buckets[index] = currentNode.next;
            size--;
            return currentNode.value;
        }

        Node<K, V> previousNode = currentNode;
        currentNode = currentNode.next;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                previousNode.next = currentNode.next;
                size--;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = buckets[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key))
                return currentNode.value;
            currentNode = currentNode.next;
        }
        return null;
    }

    public int getSize() { return this.size; }



    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new  HashMapIterator(buckets);
    }

    protected class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}


//The K is the key and V is value;
class HashMapIterator<K, V> implements Iterator<Pair<K, V>> {

    private HashMap.Node buckets[];
    private HashMap.Node currentNode;
    private HashMap.Node nextNode;
    private int index;

    public HashMapIterator(HashMap.Node buckets[]) {
        this.buckets = buckets;
        this.currentNode = null;
        this.index = 0;

        //find first node
        while (index < this.buckets.length) {
            if (this.buckets[index] != null) {
                this.currentNode = this.buckets[index];
                break;
            }
            index++;
        }

        if (this.currentNode == null)
            return;

        if (this.currentNode.next != null) {
            this.nextNode = currentNode.next;
        }
        else {
            while (++index < this.buckets.length) {
                if (this.buckets[index] != null) {
                    this.nextNode = this.buckets[index];
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (this.nextNode != null);
    }

    @Override
    public Pair<K, V> next() {
        if (this.currentNode == null)
            return null;

        Pair<K, V> returnPair = new Pair(this.currentNode.key, this.currentNode.value);

        if (this.nextNode == null) {
            this.currentNode = null;
            return returnPair;
        }

        this.currentNode = this.nextNode;

        if (this.nextNode.next != null) {
            this.nextNode = this.nextNode.next;
            return returnPair;
        }

        while (++index < this.buckets.length) {
            if (this.buckets[index] != null) {
                this.nextNode = this.buckets[index];
                return returnPair;
            }
        }

        this.nextNode = null;
        return returnPair;

    }


}
