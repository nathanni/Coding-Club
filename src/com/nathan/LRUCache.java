package com.nathan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nni on 11/14/2016.
 */
public class LRUCache {
    class ListNode {
        String key;
        String value;
        ListNode next, prev;
        public ListNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<String, ListNode> cache = new HashMap<>();
    ListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode("head", "head");
        tail = new ListNode("tail", "tail");
        head.next = tail;
        tail.prev = head;
    }



    public String getFromCache(String key) {
        if (!cache.containsKey(key)) {
            String value = getFromDB(key);
            ListNode node = new ListNode(key, value);
            if (cache.size() >= capacity) {
                ListNode tailNode = tail.prev;
                detach(tailNode);
                cache.remove(tailNode.key);
            }
            attache(node);
            cache.put(node.key, node);
            return value;
        }

        ListNode node = cache.get(key);
        detach(node);
        attache(node);
        return node.value;
    }

    public ListNode detach(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        return node;
    }
    public ListNode attache(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node;
    }


    public static String getFromDB(String key) {
        return "Value: " + key + " ";
    }

    public static void main(String[] args) {

        // test case
        // size 3
        // input Order   "A" "B" "C" "A" "D" "B"
        // output the elements in LRUCache after each operation

        // For example:
        // A: A
        // B: A B
        // C: A B C
        // A: B C A
        // D: C A D
        // B: A D B
        LRUCache cache = new LRUCache(3);
        System.out.println(cache.getFromCache("A"));
        System.out.println(cache.getFromCache("B"));
        System.out.println(cache.getFromCache("C"));
        System.out.println(cache.getFromCache("A"));
        System.out.println(cache.getFromCache("d"));
        System.out.println();
//        System.out.println(cache.getFromCache("A"));
//        System.out.println(cache.getFromCache("d"));
        ListNode cur = cache.head.next;
        while (cur != cache.tail) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}


