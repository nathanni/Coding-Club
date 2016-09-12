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

public class reverseLinkedList {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./input"));

        int n = sc.nextInt();

        while (n != -1) {
            Node dummy = new Node(-1);
            Node prev = dummy;

            while (n-- != 0) {
                Node node = new Node(sc.nextInt());
            }


        }
    }

}
