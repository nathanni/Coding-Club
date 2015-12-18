package com.nathan.leetcode.medium;

import com.nathan.leetcode.utils.ListNode;

/**
 * Created by nni on 12/18/2015.
 */

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
public class LinkedListCycle {


    /*No extra space usually means constant space. I think your solution is the best one.*/
    /*no extra space*/
    public boolean hasCycle(ListNode head) {

        if(head.next == null || head.next.next ==null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return  false;
    }

}
