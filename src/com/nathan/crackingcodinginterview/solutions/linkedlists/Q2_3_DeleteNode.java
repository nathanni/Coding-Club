package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given
only access to that node.*/

public class Q2_3_DeleteNode {
  
  public static boolean deleteNode(Node node) {
 /*   Note that this problem cannot be solved if the node to be deleted is the last node in
    the linked list. That's ok�your interviewer wants you to point that out, and to discuss
    how to handle this case. You could, for example, consider marking the node as dummy.*/
    
    if(node == null || node.next == null) {
      return false;
    }
    
    Node nextNode = node.next;
    node.data = nextNode.data;
    node.next = nextNode.next;
    return true;
  }
  
  public static void main(String[] args) {
    Node node = Node.createRanDomNode(20, 5);
    System.out.println(node);
    Node node1 = node.next;
    deleteNode(node1);
    System.out.println(node);
  }

}
