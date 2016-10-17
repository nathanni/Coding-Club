package com.nathan.crackingcodinginterview.solutions.linkedlists;


/*You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
of the list. Write a function that adds the two numbers and returns the sum as a
linked list.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.*/

public class Q2_5_AddLists {

  
  
  public static Node addLists(Node node1, Node node2, int carry) {
    if (node1 == null & node2 == null & carry == 0) {
      return null;
    }
 
    Node node = null;
    int sum = (node1 == null ? 0 : node1.data) + (node2 == null ? 0 : node2.data) + carry;
    node = new Node(sum % 10);

    node.next = addLists(node1 == null ?null:node1.next, node2 == null ?null:node2.next, sum / 10);

    return node;
  }

  
  //add two number using linkedlist
  public static int add(int num1, int num2) {
    Node n = addLists(convertToNode(num1), convertToNode(num2), 0);
    return converToInt(n);
  }

  
  //conver node to number
  private static int converToInt(Node n) {
    int num = 0;
    for (int i = 1; n != null; i *= 10) {
      num += n.data * i;
      n = n.next;
    }

    return num;
  }

  
  //Convert number to node
  public static Node convertToNode(int num) {

    Node n = null;
    Node head = null;
    int value = num;
    do {
      if (value == num) {
        n = new Node(value % 10);
        head = n;
      } else {
        n.next = new Node(value % 10);
        n = n.next;
      }
      value = value / 10;
    } while (value > 0);
    return head;
  }

  public static void main(String[] args) {

    int a = 999;
    int b = 999;

    System.out.println(add(a, b));

  }

}
