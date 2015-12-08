package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.ListNode;
import com.nathan.leetcode.utils.Stack;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/


//use 2 stacks
public class MinStack {
 
  
  ListNode listNode = null;
  
  Stack<Integer> minVals = new Stack<>();
  
  public void push(int x) {
    
    if(isEmpty() || (!minVals.isEmpty() && x <= minVals.peek())) minVals.push(x);
    
    ListNode newNode = new ListNode(x);
    newNode.next = listNode;
    listNode = newNode;
    
    
  }

  public void pop() {
    if(isEmpty()) return;
    if(!minVals.isEmpty() && top() == minVals.peek()) minVals.pop();
    listNode = listNode.next;
  }

  public int top() {
    if(isEmpty()) return Integer.MIN_VALUE;
    return listNode.val;
    
  }

  public int getMin() {
    return minVals.isEmpty()?Integer.MIN_VALUE:minVals.peek();
  }
  
  public boolean isEmpty() {
    return listNode == null;
  }
}
