package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.ListNode;

/*Given a singly linked list, determine if it is a palindrome.*/

public class PalindromeLinkedList {
  
  public static void main(String[] args) {
    ListNode n1 = ListNode.createCustomNode(1,1);
    System.out.println(isPalindrome(n1));
  }
  
  public static boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    
    ListNode fastRunner = head;
    ListNode slowRunner = head;
    while(fastRunner != null && fastRunner.next !=null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
    }
    
    if(fastRunner != null) {
      slowRunner =slowRunner.next;
    }
    
    slowRunner = reverse(slowRunner);
    
    while(slowRunner !=null) {
      if(head.val != slowRunner.val ) {
        return false;
      }
      slowRunner = slowRunner.next;
      head = head.next;
    }
    return true;
    
  }
  
  public static ListNode reverse(ListNode head) {
    ListNode node = null;
    while(head!=null) {
      ListNode next = head.next;
      head.next = node;
      node = head;
      head = next;
    }
    
    return node;
  }
}
