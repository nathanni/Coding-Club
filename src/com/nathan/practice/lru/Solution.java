package com.nathan.practice.lru;

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
            this.prev = this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
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

        //detach
        node.prev.next = node.next;
        node.next.prev = node.prev;

        int ret = node.val;

        moveToTail(node);

        return ret;

    }

    public void set(int key, int val) {
        if (get(key) != -1) {
            map.get(key).val = val;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node node = new Node(key, val);

        map.put(key, node);
        moveToTail(node);

        return;




    }

    public void moveToTail(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
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
        Scanner sc = new Scanner(new File("input"));

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
