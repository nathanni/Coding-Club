package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Reverse_Second_Half_of_LinkedList {


    public static void main(String[] args) {
//        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(7);
//        ListNode n3 = new ListNode(8);
//        ListNode n4 = new ListNode(6);
//        ListNode n5 = new ListNode(3);
//        ListNode n6 = new ListNode(4);
//        ListNode n7 = new ListNode(2);
//        n1.next = n2;
//        n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;



        print(n1);

        ListNode reversed = reverseHalfList(n1);
        print(reversed);

    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }



    public static ListNode reverseHalfList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode org = head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverseList(slow.next);
        slow.next = reversed;

        return org;
    }

    private static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
