package com.nathan.amazon;

/**
 * Created by Nathan on 11/21/16.
 */
public class Loop_In_LinkedList {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;

    }
}
