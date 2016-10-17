package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*2.4 Write code to partition a linked list around a value x, such that all nodes less than x
come before all nodes greater than or equal to x.*/

public class Q2_4_PartionLinkedList {
  
  
  
  
  public static Node partion1(Node node, int value) {
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;
    
    while(node != null) {
      Node nextNode = node.next;
      node.next = null;
      
      if(node.data < value) {
        if(beforeStart == null) {
          beforeStart = node;
          beforeEnd = node;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      }
      
      if(node.data >= value) {
        if(afterStart == null) {
          afterStart = node;
          afterEnd = node;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      
      node = nextNode;
    }
    
    if(beforeStart == null) {
      return afterStart;
    }
    
    beforeEnd.next = afterStart;
    return beforeStart;
    
  }
  
  public static Node partion2(Node node, int value) {
    Node before = null;
    Node after = null;
    
    while(node != null) {
      Node nextNode = node.next;
      node.next = null;
      if(node.data < value) {
        node.next = before;
        before = node;
      } else {
        node.next = after;
        after = node;
      }
      
      node = nextNode;
    }
    
    if(before == null) {
      return after;
    }
    
    Node current = before;
    while(before.next != null) {
      before = before.next;
    }
    before.next = after;
    
    return current;
  }
  
  
  public static void main(String[] args) {
    Node n = Node.createRanDomNode(20, 10);
    System.out.println(n);
    System.out.println(partion2(n, 8));
  }
}
