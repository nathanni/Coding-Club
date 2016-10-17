package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*Implement a function to check if a linked list is a palindrome*/

public class Q2_7_PalindromeLinkedList_Recursion {
  
  
 
  static class Result {
    Node node;
    boolean result;
    
    public Result(Node node, boolean result) {
      this.node = node;
      this.result = result;
    }
    
    public Result() {
      // TODO Auto-generated constructor stub
    }
  }
  
  public static Result isPalindromeRecurse(Node head, int length) {
    if(length == 0 || head == null) {
      return new Result(null,true);
    } else if(length == 1) {
      return new Result(head.next, true);
    }
    else if(length == 2) {
      return new Result(head.next.next, head.data == head.next.data);
    }
    
    Result result = isPalindromeRecurse(head.next, length-2);
    
    if(result == null || result.result == false) {
      return result;
    }
    
    result.result = head.data == result.node.data;
    result.node = result.node.next;
    
    return result;
  }
  
  public static boolean isPalindrome(Node head) {
    return isPalindromeRecurse(head, head.length()).result;
  }
  
  public static void main(String[] args) {
    Node n = Node.createCustomNode(1,2,3,2);

    System.out.println(isPalindrome(n));
  }

}
