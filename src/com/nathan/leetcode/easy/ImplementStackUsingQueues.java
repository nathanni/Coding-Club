package com.nathan.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.nathan.leetcode.utils.ListNode;

/*Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/



public class ImplementStackUsingQueues {
  
  
  public static void main(String[] args) {
    ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();
    myStack.push(1);
    myStack.push(2);
    System.out.println(myStack.top());
  }
  
  
  MyQueue myQueue = new MyQueue();
  
  // Push element x onto stack.
  public void push(int x) {
    myQueue.push(x);
    for(int i = 0 ; i < myQueue.size() - 1; i++) {
      myQueue.push(myQueue.pop());
    }
  }

  // Removes the element on top of the stack.
  public void pop() {
    myQueue.pop();
      
  }

  // Get the top element.
  public int top() {
    return myQueue.peek();
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return myQueue.isEmpty();
      
  }
}

class MyQueue {
  ListNode curr;
  ListNode last;
  int length;
  
  public MyQueue() {
    length = 0;
    curr = null;
    last = null;
  }
  
  public int size() {
    return length;
    
  }
  public void push(int x) {
    ListNode newNode = new ListNode(x);
    if(isEmpty()) {
      curr = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    length++;
    
  }
  
  public int pop() {
    if(isEmpty()) {
      return Integer.MIN_VALUE;
    }
    int num = curr.val;
    curr = curr.next;
    length--;
    return num;
    
    
  }
  
  public int peek() {
    if(isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return curr.val;
  }
  
  public boolean isEmpty() {
    return curr == null ? true: false;
  }
  
  
}



//LEETCODE SOLUTION
class MyStack 
{
    Queue<Integer> queue;

    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}