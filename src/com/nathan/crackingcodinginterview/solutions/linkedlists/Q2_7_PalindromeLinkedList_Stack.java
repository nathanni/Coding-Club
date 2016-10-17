package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*Implement a function to check if a linked list is a palindrome*/

public class Q2_7_PalindromeLinkedList_Stack {

  public static boolean isPalindrome(Node head) {
    Node fastrunner = head;
    Node slowrunner = head;
    Stack<Integer> stack = new Stack<>();
    
    while(fastrunner != null && fastrunner.next != null) {
      stack.push(slowrunner.data);
      slowrunner = slowrunner.next;
      fastrunner = fastrunner.next.next;
    }
    
    //need to handle the case when the length of the list is odd
    if(fastrunner != null && fastrunner.next == null) {
      slowrunner = slowrunner.next;
    }
    
    while(!stack.isEmpty()) {
      if(stack.pop() != slowrunner.data) {
        return false;
      }
      slowrunner = slowrunner.next;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    Node n = Node.createCustomNode(123,423,123,6,123,423,123,2);
    

    System.out.println(isPalindrome(n));
  }
}
