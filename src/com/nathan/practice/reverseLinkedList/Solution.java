package com.nathan.practice.reverseLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nathan on 9/8/2016.
 */
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public void print() {
        Node node = this;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}

public class Solution {

    public static Node reverseIteration(Node head) {
        Node ret = null;
        while (head != null) {
            Node next = head.next;
            head.next = ret;
            ret = head;
            head = next;
        }
        return ret;

    }

    public static Node reverseRecursion(Node head) {
        if (head == null || head.next == null) return head;


        Node node = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/practice/reverseLinkedList/input"));

        int n = sc.nextInt();
        Node dummy = new Node(-1);
        while (n != -1) {
            Node prev = dummy;
            while (n-- != 0) {
                Node node = new Node(sc.nextInt());
                prev.next = node;
                prev = node;
            }
            n = sc.nextInt();
        }

        Node head = dummy.next;
        head.print();

        //System.out.println("reverse iteration ");
        //reverseIteration(head).print();
        System.out.println("reverse recursion: ");
        reverseRecursion(head).print();
    }

}
