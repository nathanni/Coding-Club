package com.nathan.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 11/21/16.
 */


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Copy_List_With_Random_Pointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode prev = null;
        RandomListNode org = head;
        while (head != null) {
            RandomListNode newHead = new RandomListNode(head.label);
            map.put(head, newHead);

            if (prev != null) {
                map.get(prev).next = newHead;
            }
            prev = head;
            head = head.next;
        }

        head = org;

        while (head != null) {
            map.get(head).random = map.get(head.random);
            head = head.next;
        }

        return map.get(org);

    }
}
