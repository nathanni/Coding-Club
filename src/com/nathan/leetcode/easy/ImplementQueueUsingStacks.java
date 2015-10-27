package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.ListNode;

/*Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).*/



//amortized O(1) from leetcode 
/*class MyQueue {

  Stack<Integer> input = new Stack();
  Stack<Integer> output = new Stack();

  public void push(int x) {
      input.push(x);
  }

  public void pop() {
      peek();
      output.pop();
  }

  public int peek() {
      if (output.empty())
          while (!input.empty())
              output.push(input.pop());
      return output.peek();
  }

  public boolean empty() {
      return input.empty() && output.empty();
  }
}*/

public class ImplementQueueUsingStacks {

  MyStack s1 = new MyStack();
  MyStack s2 = new MyStack();
  int size = 0;


  // Push element x to the back of queue.
  public void push(int x) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }

    s1.push(x);

    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    ++size;

  }

  // Removes the element from in front of queue.
  public void pop() {
    s1.pop();
    --size;
  }

  // Get the front element.
  public int peek() {
    return s1.peek();

  }

  // Return whether the queue is empty.
  public boolean empty() {
    return s1.isEmpty();
  }

  class MyStack {
    ListNode curr;
    int size;

    public MyStack() {
      curr = null;
      size = 0;
    }

    void push(int x) {
      ListNode listNode = new ListNode(x);
      listNode.next = curr;
      curr = listNode;
      ++size;

    }

    int pop() {
      if (!isEmpty()) {
        int item = curr.val;
        curr = curr.next;
        --size;
        return item;
      }
      return Integer.MIN_VALUE;
    }

    int peek() {
      if (!isEmpty())
        return curr.val;
      return Integer.MIN_VALUE;
    }

    int getsSize() {
      return size;
    }

    boolean isEmpty() {
      return curr == null ? true : false;
    }
  }
}
