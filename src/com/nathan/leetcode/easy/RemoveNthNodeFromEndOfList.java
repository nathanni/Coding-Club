package com.nathan.leetcode.easy;


import com.nathan.leetcode.utils.ListNode;

/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

public class RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    ListNode n1 = ListNode.createCustomNode(1,2,3,4,5,6,7,123,1);
    //System.out.println(reverseNode(n1));
    System.out.println(removeNthFromEnd(n1, 1));
  }
  
  
  //first solution, find the nth node to the end first, then delete it
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    

    ListNode p1 = head;
    ListNode p2 = head;
    
    for(int i = 0; i < n; i ++) {
      p2 = p2.next;
    }
    
    //nth to the end is the first element
    if(p2 == null) {
      return head.next;
    }
    
    while(p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    
    p1.next = p1.next.next;
    
    return head;

  }
  
  //reverse the linkedlist first.
  public static ListNode removeNthFromEnd2(ListNode head, int n) {
    

    ListNode node = reverseNode(head);
    ListNode org = node;
    
    if(n == 1)
      return reverseNode(node.next);

    
    for(int i = 0; i < n-2; i++) {
      node = node.next;
    }
    
    node.next = node.next.next;
    return reverseNode(org);
  }


  private static ListNode reverseNode(ListNode head) {
    ListNode node = null;
    while(head != null) {
      ListNode next = head.next;
      head.next = node;
      node = head;
      head = next;
    }
    return node;
    
  }
  
}
