package com.nathan.leetcode.easy;

import java.time.chrono.MinguoChronology;

import com.nathan.leetcode.utils.ListNode;

/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.*/
public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode l1 = ListNode.createCustomNode(1,2,3,4,5,7,8,32);
    ListNode l2 = ListNode.createCustomNode(2,3,5,7,24,33);
    
    System.out.println(mergeTwoLists(l1, l2));
  }
  
  
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 
    if(l1 == null || l2 == null) {
      return l1 == null?l2:l1;
    }
    
    ListNode minNode = min(l1, l2)?l1:l2;
    ListNode head = minNode;
    
    if(minNode == l1) l1 = l1.next;
    else l2 = l2.next;
    
    while(l1!=null && l2!=null) {
      
      if(min(l1, l2)) {
        minNode.next = l1;  
        l1 = l1.next;
      } else {
        minNode.next = l2;  
        l2 = l2.next;
      }
      minNode = minNode.next;
    };
    
    if(l1==null) {
      minNode.next =l2;
    } else {
      minNode.next = l1;
    }
    
    return head;
    
  }

  private static boolean min(ListNode l1, ListNode l2) {
    
    return l1.val <= l2.val ? true:false;
  }
}
