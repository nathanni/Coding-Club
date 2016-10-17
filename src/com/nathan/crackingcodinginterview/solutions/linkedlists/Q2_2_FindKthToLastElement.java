package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*
2.2 Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class Q2_2_FindKthToLastElement {
  
  
  // Solution 1: recursive    Space: O(n)
  private static int i = 0; //counter
  public static Node KthToLast1(Node head, int k) {
    if(head == null) {
      return null;
    }
    
    Node node = KthToLast1(head.next, k);
    i++;
    if(i == k) {
      return head;
    }
    return node;
    
  }
  
  // Solution 2:
/*  A more optimal, but less straightforward, solution is to implement this iteratively. We can
  use two pointers, pi and p2. We place them k nodes apart in the linked list by putting pi
  at the beginning and moving p2 k nodes into the list. Then, when we move them at the
  same pace, p2 will hit the end of the linked list after LENGTH - k steps. At that point, pi
  will be LENGTH - k nodes into the list, or k nodes from the end.*/
  public static Node KthToLast2(Node head, int k) {
    if(k <= 0) return null;
    
    Node p1 = head;
    Node p2 = head;
    
    for(int i = 0; i < k; i++) {
      if(p1 == null) return null;
      p1 = p1.next;
    }
    
    while(p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    
    return p2;
    
    
  }
  
  
  
  public static void main(String[] args) {
    Node n = Node.createRanDomNode(20, 10);
    System.out.println(n);
    
    System.out.println(KthToLast1(n, 5));
    System.out.println(KthToLast2(n, 5));
  }

}


