package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
of the list. Write a function that adds the two numbers and returns the sum as a
linked list.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.*/

public class Q2_5_AddListsInForwardOrder {

  public static class partialSum {
    Node sum;
    int carry;

  }

  public static Node addListsInForwardOrder(Node node1, Node node2) {
    
    if(node1.length() != node2.length()) {
      if(node1.length() > node2.length()) {
        node2 = padNode(node2, node1.length()-node2.length());
      } else {
        node1 = padNode(node1, node2.length()-node1.length());
        
      }
    }

    partialSum sum = addListsHelper(node1, node2);
    
    if(sum.carry == 0) {
      return sum.sum;
    } else {
      Node node = new Node(1);
      node.next = sum.sum;
      return node;
    }
    
  }
  
  //Pad the list with zeros
  public static Node padNode(Node node, int n) {

    for(int i = 0; i < n; i++) {
      Node nodeZero= new Node(0);
      nodeZero.next = node;
      node = nodeZero;
    }
    
    return node;
  }
  
  

  //Helper function to insert node in the front of a linked list
  public static partialSum addListsHelper(Node node1, Node node2) {

    partialSum sum = new partialSum();

    if (node1 == null && node2 == null) {
      return sum;
    }


    sum = addListsHelper(node1.next, node2.next);

    int value = node1.data + node2.data + sum.carry;
    Node node = new Node(value%10);
    
    node.next = sum.sum;

    sum.sum = node;
    sum.carry = value / 10;
    
    return sum;

  }

  public static void main(String[] args) {
    Node n1 = Node.createCustomNode(9,9,9,9);
    Node n2 = Node.createCustomNode(1,0,0,0,0);
    Node n = addListsInForwardOrder(n1, n2);
    System.out.println(n1);
    System.out.println(n2);
    System.out.println(n);
    
  }

}
