package com.nathan.crackingcodinginterview.solutions.linkedlists;

import java.util.Random;

public class Node {

  public Node next = null;
  public int data;

  public Node(int data) {
    this.data = data;
  }

  
  public int length(){
    int N = 0;
    Node n = this;
    while (n != null) {
      n = n.next;
      ++N;
    }
    return N;
  }
  
  public Node getTail() {
    Node n = this;
    while (n.next != null) {
      n = n.next;
    }
    return n;
  }

  public void appendToTail(int data) {
    Node node = new Node(data);
    this.getTail().next = node;
  }

  // delete node from list
  public static Node deleteNode(Node head, int data) {
    if (head.data == data) {
      return head.next;
    }

    Node n = head;

    while (n.next != null) {
      if (n.next.data == data) {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head;
  }

  // create a random
  public static Node createRanDomNode(int bound, int length) {
    Node node = new Node(new Random().nextInt(bound));

    for (int i = 1; i < length; i++) {
      node.appendToTail(new Random().nextInt(bound));
    }
    return node;
  }

  // create a customize Node
  public static Node createCustomNode(int... arr) {
    Node nodeList = null;
    Node head = null;

    for (int i : arr) {
      if (nodeList == null) {
        nodeList = new Node(i);
        head = nodeList;
      } else {
        Node node = new Node(i);
        nodeList.next = node;
        nodeList = node;
      }

    }
    return head;
  }

  @Override
  public String toString() {
    Node n = this;
    String str = n.data + "";
    while (n.next != null) {
      n = n.next;
      str += "-" + n.data;
    }
    return str;
  }

  // test
  public static void main(String[] args) {
    Node n = createCustomNode(0,2,5,7,1,22);
    System.out.println(n);
    System.out.println(n.length());

  }

}
