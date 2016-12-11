package com.nathan.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nathan on 12/11/2016.
 */
public class SeparateChainingHashTableLite<Key, Value> {
    private int count; //numbers of key-value pairs
    private int hashSize; //hash table size
    private Node[] st; //array of linked-list symbol table

    private static class Node {
        private Object key;
        private Object val;
        private Node next;
        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainingHashTableLite() {
        this(997);
    }
    public SeparateChainingHashTableLite(int hashSize) {
        this.hashSize = hashSize;
        this.st = new Node[hashSize];
    }

    private int hash(Key key) {
        return (key.hashCode() & Integer.MAX_VALUE) % hashSize;

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;

    }

    public Value get(Key key) {
        int i = hash(key);

        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return (Value)x.val;
            }
        }

        return null;
    }

    public void put(Key key, Value value) {
        
        if(value == null) {
            delete(key);
            return;
        }
        
        
        int i = hash(key);

        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = value;
                return; //very important
            }
        }
        count++;

        st[i] = new Node(key, value, st[i]);

    }

    private void delete(Key key) {
        throw new UnsupportedOperationException();
    }

    private Iterable<Key> keySet(){
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < hashSize; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.offer((Key) x.key);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainingHashTableLite<String, Integer> st = new SeparateChainingHashTableLite<String, Integer>(970000);




        for (int i = 0; i < 5000000; i++) {
            st.put("test" + i, i);
        }

        for (String k: st.keySet()) {
            System.out.print(k + " ");
            System.out.println(st.get(k));
        }

    }


}
