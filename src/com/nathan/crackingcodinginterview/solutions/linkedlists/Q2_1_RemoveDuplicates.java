package com.nathan.crackingcodinginterview.solutions.linkedlists;

import java.util.Hashtable;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */


public class Q2_1_RemoveDuplicates {
  
  
  //space O(n)  time O(n)
  public static void deleteDups1(Node n) {
    if(n == null) return;
    
    Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
    Node previous = null;
    
 // care, is not "n.next != null"
    while(n != null) {
      if(hashtable.containsKey(n.data)) {
        previous.next = n.next;
      } else {
        hashtable.put(n.data, true);
        previous = n;
      }
      n = n.next;
    }
    
  }
  
  //Do not use buffer, lowest space cosuming   O(1)
  public static void deleteDups2(Node n) {
    if(n == null) return;
    
    while(n != null) {
      Node runner = n;
      while(runner.next != null) {
        if(runner.next.data == n.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      n = n.next;
      
    }
  }
  
  
  public static void main(String[] args) {
/*    Node n = new Node(1);
    
    for(int i = 0; i < 20; i++) {
      n.appendToTail(new Random().nextInt(21));
    }
    
    Node m = n;
    
    System.out.println("N: " + n);
    System.out.println("M: " + m);
    
    deleteDups1(n);
    deleteDups2(m);
    
    System.out.println("N: " + n);
    System.out.println("M: " + m);*/
    
    Node n = Node.createCustomNode(3,3);
    System.out.println(n);
    deleteDups1(n);
    System.out.println(n);
  }
}
