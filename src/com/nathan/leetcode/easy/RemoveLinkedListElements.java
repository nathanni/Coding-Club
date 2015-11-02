package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.ListNode;

/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5*/

public class RemoveLinkedListElements {
  public static void main(String[] args) {
    ListNode n1 = ListNode.createCustomNode(1,2,6,3,4,5,6);
    System.out.println(removeElements(n1, 6));
  }
  
  
  //smart solution, use recursion
  public static ListNode removeElements(ListNode head, int val) {
    if(head == null) return null;
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next:head;
  }
    
  
  
  //my solution, use dummy
  public static ListNode removeElements2(ListNode head, int val) {
    
    ListNode newNode = new ListNode(Integer.MIN_VALUE);
    ListNode org = newNode;
    while(head != null) {
      ListNode next = head.next;
      head.next = null;
      if(head.val == val) {
        head = next;
        continue;
      }
      newNode.next = head;
      newNode = newNode.next;
      head = next;
    }
    
    return org.next;
   
  }
}
