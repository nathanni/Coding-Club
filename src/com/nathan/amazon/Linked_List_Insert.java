package com.nathan.amazon;

/**
 * Created by Nathan on 11/21/16.
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class Linked_List_Insert {

    public ListNode solution(ListNode head, int val) {
        if (head == null) {
            ListNode node =  new ListNode(val);
            node.next = node;
            return node;
        }

        ListNode curr = head;
        do {

            //case 1
            //Insert between prev and current.
            if (val >= curr.val && val <= curr.next.val) break;

            //case 2
            //x is the maximum or minimum value in the list:
            //Insert before the head. (ie, the head has the smallest value and its prev→val > head→val.
            else if (curr.val > curr.next.val && (val > curr.val || val < curr.next.val)) break;
            curr = curr.next;
        } while (curr != head);
        // case 3
        // for duplicates
        //Traverses back to the starting point:
        //Insert before the starting point.

        ListNode node = new ListNode(val);
        node.next = curr.next;
        curr.next = node;
        return node;

    }
}
