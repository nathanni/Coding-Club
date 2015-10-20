package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.ListNode;

/*Reverse a singly linked list.
 * 
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?*/
public class ReverseLinkedList {

  // iteratively
  public ListNode reverseList(ListNode head) {
    ListNode node = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = node;
      node = head;
      head = next;
    }
    return node;
  }
  
  //recursively
  public ListNode reverseList2(ListNode head) {
    return null;
    
  }
}
