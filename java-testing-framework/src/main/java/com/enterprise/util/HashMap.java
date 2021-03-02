package com.enterprise.util;

public class HashMap<K,V> {

    Node<K, V> buckets[];
    int size;
    int capacity;
    double loadFactor;

    public HashMap() {
        capacity = 10;
        buckets = new Node[capacity];
        size = 0;
        loadFactor = .5;
    }

    public boolean add(K key, V value) {

        //refactor when loadFactor is exceeded.
        if (size / capacity > loadFactor) {
            capacity *= 2;
            Node<K, V> newBuckets[] = new Node[capacity];
        }

        return false;
    }

    public V remove(K key) {
        return null;
    }

    public V get(K key) {
        return null;
    }

}

class Node<K, V> {
    K key;
    V data;
    Node next;

    public Node(K key, V data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public Node(K key, V data, Node next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}
