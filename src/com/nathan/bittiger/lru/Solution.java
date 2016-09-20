package com.nathan.bittiger.lru;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nathan on 9/8/16.
 */

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        detatch(node);
        attach(node);
        return node.val;
    }

    public void set(int key, int val) {
        if (get(key) != -1) {
            map.get(key).val = val;
            return;
        }

        if (this.capacity == map.size()) {
            Node node = head.next;
            map.remove(node.key);
            detatch(node);
        }

        Node node = new Node(key, val);
        map.put(key, node);
        attach(node);
    }

    public void detatch(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void attach(Node node) {
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
    }



}

class LRUCache2<K, V> extends LinkedHashMap<K, V> {
    private int capacity;
    LRUCache2(int capacity) {
        super(128, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}


public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/lru/input"));

        int n = sc.nextInt();

        while (n != -1) {
            LRUCache lruCache = new LRUCache(n);

            int m = sc.nextInt();

            while(m-- != 0) {
                sc.nextLine();
                String op = sc.next();
                if (op.equals("SET")) {
                    lruCache.set(sc.nextInt(), sc.nextInt());
                } else {
                    System.out.println(lruCache.get(sc.nextInt()));
                }
            }

            n = sc.nextInt();

        }

        sc.close();
    }
}
