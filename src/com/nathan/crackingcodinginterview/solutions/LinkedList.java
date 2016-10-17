package com.nathan.crackingcodinginterview.solutions;



public class LinkedList {

	public static void main(String[] args) {
		Node n = new Node(1234);
		n.appendToTail(123);
		n.appendToTail(5665);
		System.out.println(n);
		System.out.println(n.getTail());

		System.out.println("------DELETE-----");

		Node m = Node.deleteNode(n, 5665);
		System.out.println(m);
	}

}

class Node {

	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	Node getTail() {
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}

		return n;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		getTail().next = end;
	}


	//delete d in Node head
	public static Node deleteNode(Node head, int d) {
		Node n = head;

		if(head.data == d) {
			return head.next;
		}

		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}

		return head;

	}

	@Override
	public String toString() {
		Node n = this;
		String str = n.data +"";
		while(n.next!=null) {
			n = n.next;
			str += "-"+ n.data;
		}
		return str;
	}
}

