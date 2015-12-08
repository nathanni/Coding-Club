package com.nathan.leetcode.easy;

//use node with min
public class MinStack2  {
  
  class NodeWithMin {
    int val;
    int min;
    NodeWithMin next;
    public NodeWithMin(int val, int min) {
      this.val = val;
      this.min = min;
      next = null;
    }
  }
  
  NodeWithMin node;
  
  public void push(int x) {
    if(isEmpty()) node = new NodeWithMin(x, x);
    else {
      NodeWithMin newNode = new NodeWithMin(x, x<=getMin()?x:getMin());
      newNode.next = node;
      node = newNode;
    }
    
  }

  public void pop() {
    if(isEmpty()) return;
    node = node.next;
  }

  public int top() {
    return node.val;
      
  }

  public int getMin() {
    return node.min;
  }
  
  public boolean isEmpty() {
    return node == null;
  }
}
