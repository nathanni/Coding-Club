package com.nathan.leetcode.easy;
/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

import com.nathan.leetcode.utils.ListNode;

public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    int n = 1;
    int m = 1;
    ListNode p, q;
    p = headA;
    while (p.next != null) {
      n++;
      p = p.next;
    }
    p = headB;
    while (p.next != null) {
      m++;
      p = p.next;
    }
    p = headA;
    q = headB;
    if (n < m) {
      for (int i = 1; i <= m - n; i++)
        q = q.next;
    } else if (n > m) {
      for (int i = 1; i <= n - m; i++)
        p = p.next;
    }
    while (p != null && p != q) {
      p = p.next;
      q = q.next;
    }
    return p;
  }
}
