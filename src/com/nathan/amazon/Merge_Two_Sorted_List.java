package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Merge_Two_Sorted_List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }

        }

        prev.next = l1 == null ? (l2 == null ? null : l2) : l1;

        return dummy.next;


    }
}
