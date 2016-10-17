package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*Implement a function to check if a linked list is a palindrome*/

public class Q2_7_PalindromeLinkedList_Reverse {

    public static boolean isPalindrome(Node head) {
        if (head == null) return false;
        if (head.next == null) return true;

        Node reverseNode = reverseLinkedList2(head);

        Node fastrunner = head;

        while (fastrunner != null && fastrunner.next != null) {
            if (reverseNode.data != head.data) {
                return false;
            }
            fastrunner = fastrunner.next.next;
            reverseNode = reverseNode.next;
            head = head.next;
        }

        return true;

    }

    //iteration  won't affect head  O(N) space
    public static Node reverseLinkedList2(Node head) {
        if (head == null) return null;
        Node node = null;
        while (head != null) {
            Node newNode = new Node(head.data);
            newNode.next = node;
            node = newNode;
            head = head.next;
        }
        return node;
    }

    //iteration    O(1) space
    public static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        Node node = null;
        while (head != null) {
            Node next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }

    //recursive
    public static Node reverseList(Node head) {
        if (head == null) return null;
        return helper(null, head);
    }

    static Node helper(Node reversed, Node remaining) {
        if (remaining == null) return reversed;
        Node tmp = remaining.next;
        remaining.next = reversed;

        return helper(remaining, tmp);
    }

    public static Node reverseList2(Node head) {
        if (head == null || head.next == null) return head;

        Node next = head.next;
        head.next = null;

        Node newNode = reverseList2(next);

        next.next = head;

        return newNode;


    }

    public static void main(String[] args) {

        Node n = Node.createCustomNode(123, 423, 123, 6, 123, 423, 123, 9123, 1332);


        System.out.println(reverseList2(n));
        System.out.println(isPalindrome(n));
    }
}
