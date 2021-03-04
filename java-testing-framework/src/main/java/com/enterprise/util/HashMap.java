package com.enterprise.util;


public class HashMap<K,V> {

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
        if (Math.abs(capacity / (size + 1)) < loadFactor) {
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
            buckets[index] = null;
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

    public int getSize() { return size; }



    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private class Node<K, V> {
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
