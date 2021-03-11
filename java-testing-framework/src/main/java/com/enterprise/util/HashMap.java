package com.enterprise.util;

import java.util.Iterator;

public class HashMap<K,V> implements Iterable<HashMap.Node<K,V>> {

    Node<K, V>[] buckets;
    int size;
    final int capacity;

    public HashMap() {
        capacity = 11;
        buckets = new Node[capacity];
        size = 0;
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        buckets = new Node[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % capacity);


        if(buckets[index] == null){
            buckets[index] = new Node<>(key, value);
        }
        else{
            Node<K, V> temp;
            temp = buckets[index];

            if(buckets[index].key.equals(key)){
                return;
            }

            while(temp.next != null){

                if(temp.key.equals(key)){
                    return;
                }

                temp = temp.next;
            }
            temp.next = new Node<>(key, value);
        }
        size++;

    }

    public void remove(K key) {
        int index = key.hashCode() % capacity;

        if(buckets[index] == null){
            return;
        }
        else if(buckets[index].key.equals(key)){
            buckets[index] = buckets[index].next;
            size--;
        }
        else{
            Node<K, V> temp;
            temp = buckets[index];

            while(temp.next != null && !temp.next.key.equals(key)){
                temp = temp.next;
            }

            if(temp.next == null){
                return;
            }

            if(temp.next.key.equals(key)){
                System.out.println("Key Found");
                if(temp.next.next != null){
                    temp = temp.next.next;
                }else{
                    temp.next = null;
                }
                size--;
            }
        }
    }


    public V get(K key) {

        int index = key.hashCode() % capacity;

        if(buckets[index] == null){
            return null;
        }
        else{
            Node<K, V> temp;
            temp = buckets[index];

            while(temp.key != key && temp.next != null){
                temp = temp.next;
            }
            if(temp.key == key) {
                return temp.data;
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Node<K,V> n : buckets){
            if(n != null){
                Node<K,V> n3 = n;
                do {
                    result.append(n3.toString() + System.lineSeparator());
                    n3 = n3.next;
                } while (n3 != null);
            }
        }
        return result.toString();
    }

    @Override
    public Iterator<Node<K, V>> iterator() {

        Node<K,V>[] temp = new Node[size];
        int i = 0;
        if (size==0) return null;
        for (Node<K,V> n: buckets) {
            if (n != null) {
                Node<K, V> node = n;
                do {
                    temp[i] = node;
                    i++;
                    node = node.next;
                } while (node != null);

            }

        }

            return new Iterator<Node<K,V>>() {
            int cursor = 0;
            Node<K,V>[] itr =temp;


                @Override
                public boolean hasNext() {

                    return cursor != size;
                }

                @Override
                public Node<K, V> next() {
                    return itr[cursor++];
                }
            };
        }



    protected static class Node<K, V> {
        K key;
        V data;
        Node<K,V> next;

        public Node(K key, V data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public Node(K key, V data, Node<K,V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        public String toString(){
            return "Key: " + this.key.toString() + System.lineSeparator() + "Data: " + this.data.toString();
        }
    }

    public int getSize() {
        return size;
    }
}
