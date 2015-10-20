package com.nathan.getintersectionnode;

public class Solution {
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
