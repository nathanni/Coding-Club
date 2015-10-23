package com.nathan.leetcode.utils;

import java.util.Random;

public class ListNode {

  public ListNode next = null;
  public int val;

  public ListNode(int data) {
    this.val = data;
  }

  
  public int length(){
    int N = 0;
    ListNode n = this;
    while (n != null) {
      n = n.next;
      ++N;
    }
    return N;
  }
  
  public ListNode getTail() {
    ListNode n = this;
    while (n.next != null) {
      n = n.next;
    }
    return n;
  }

  public void appendToTail(int data) {
    ListNode node = new ListNode(data);
    this.getTail().next = node;
  }

  // delete node from list
  public static ListNode deleteNode(ListNode head, int data) {
    if (head.val == data) {
      return head.next;
    }

    ListNode n = head;

    while (n.next != null) {
      if (n.next.val == data) {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head;
  }

  // create a random
  public static ListNode createRanDomNode(int bound, int length) {
    ListNode node = new ListNode(new Random().nextInt(bound));

    for (int i = 1; i < length; i++) {
      node.appendToTail(new Random().nextInt(bound));
    }
    return node;
  }

  // create a customize Node
  public static ListNode createCustomNode(int... arr) {
    ListNode nodeList = null;
    ListNode head = null;

    for (int i : arr) {
      if (nodeList == null) {
        nodeList = new ListNode(i);
        head = nodeList;
      } else {
        ListNode node = new ListNode(i);
        nodeList.next = node;
        nodeList = node;
      }

    }
    return head;
  }

  @Override
  public String toString() {
    ListNode n = this;
    String str = n.val + "";
    while (n.next != null) {
      n = n.next;
      str += "-" + n.val;
    }
    return str;
  }

  // test
  public static void main(String[] args) {
    ListNode n = createCustomNode(0,2,5,7,1,22);
    System.out.println(n);
    System.out.println(n.length());

  }

}
