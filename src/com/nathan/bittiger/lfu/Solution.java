package com.nathan.bittiger.lfu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nni on 9/20/2016.
 */
class LFUCache {
    class Node {
        int freq;
        List<Integer> items;
        Node prev;
        Node next;
        public Node(int freq) {
            this.freq = freq;
            this.prev = this.next = null;
            this.items = new ArrayList<>();
        }
    }
    class Item {
        int key;
        int val;
        Node parent;
        public Item(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    HashMap<Integer, Item> map;
    Node head;
    Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0);
        this.tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Item item = map.get(key);

        Node parent = item.parent;

        if (parent.next.freq == parent.freq + 1) {
            item.parent = parent.next;
        } else {
            Node newParent = new Node(parent.freq + 1);

            newParent.next = parent.next;
            parent.next = newParent;
            newParent.prev = parent;
            newParent.next.prev = newParent;



            item.parent = newParent;
        }
        removeItem(parent,item.key);
        validateNode(parent);
        item.parent.items.add(item.key);

        return item.val;
    }

    private void validateNode(Node parent) {
        if (parent.items.size() == 0) {
            parent.prev.next = parent.next;
            parent.next.prev = parent.prev;
        }
    }

    private void removeItem(Node parent, int key) {
        parent.items.remove(new Integer(key));
    }

    public void set(int key, int val) {
        if(get(key) != -1) {
            map.get(key).val = val;
            return;
        }

        if(this.capacity == map.size()) {
            Node first = head.next;
            map.remove(first.items.get(0));
            first.items.remove(0);
            validateNode(first);

        }

        Item item = new Item(key, val);
        Node parent;
        if (head.next.freq == 1) {
            parent = head.next;
        } else {
            parent = new Node(1);

            parent.next = head.next;
            head.next = parent;
            parent.next.prev = parent;
            parent.prev = head;
        }
        parent.items.add(item.key);
        item.parent = parent;

        map.put(key, item);
        return;



    }

}

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/lfu/input"));

        int n = sc.nextInt();
        LFUCache lfuCache = new LFUCache(n);

        n = sc.nextInt();
        while (n != -1) {

            int m = n;
            while (m-- > 0) {
                sc.nextLine();
                String operator = sc.next();
                if (operator.equals("SET")) {
                    lfuCache.set(sc.nextInt(), sc.nextInt());
                } else {
                    System.out.println(lfuCache.get(sc.nextInt()));
                }
            }

            n = sc.nextInt();

        }
        sc.close();

    }
}
