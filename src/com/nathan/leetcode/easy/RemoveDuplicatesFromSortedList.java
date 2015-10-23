package com.nathan.leetcode.easy;

import java.util.Hashtable;

import com.nathan.leetcode.utils.ListNode;
/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/



public class RemoveDuplicatesFromSortedList {
  
  public static void main(String[] args) {

    ListNode n = ListNode.createCustomNode(5,123,53523,1,1,3,4,5,6,1,1,0,0);
    System.out.println(n);
    
    System.out.println(deleteDuplicates2(n));
    
  }
  
  
  //Note:  Pay attentions to the quetion, actually it is a sorted linked list, so the solution could be O(n). From Leetcode
  
  public ListNode deleteDuplicates3(ListNode head) {
    if(head == null || head.next == null)return head;
    head.next = deleteDuplicates3(head.next);
    return head.val == head.next.val ? head.next : head;
  }

  
  //No hashtable solution O(n2) runtime
  public static ListNode deleteDuplicates2(ListNode head) {
    if(head == null) {
      return null;
    }
    
    ListNode org = head;
    ListNode prev = null;
    ListNode second = null;
    
    while(head != null) {
      second = head.next;
      prev = head;
      while(second != null) {
        if(head.val == second.val) {
          prev.next = second.next;
          second = second.next;
        } else {
          second = second.next;
          prev = prev.next;
        }
      }
      head = head.next;
      
    }
    
    return org;
  }
  
  
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    
    ListNode org = head;
    ListNode prev = null;
    
    Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
    
    // care, is not "head.next != null"
    while(head!= null) {
      if(hashtable.containsKey(head.val)) {
        prev.next = head.next;
      } else {
        hashtable.put(head.val, true);
        prev = head;
      }
      
      head = head.next;
    }
    
    return org;
    
  }
}
