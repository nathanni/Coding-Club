package com.nathan.crackingcodinginterview.solutions.stackandqueue;

import java.util.NoSuchElementException;

/*Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
pop () should behave identically to a single stack (that is, pop () should return the
same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a
specific sub-stack.*/

//My solution
public class Q3_3_SetOfStacks<Item> {

  private static final int CAPACITY = 5;
  private Node singleStack;
  private int count; // count how many single stacks
  private Node lastSingleStack; // a pointer to the last single stack;

  private class Node {
    Stack<Item> s; // stack in each node
    Node next;
    int length; // length of items in each stack

    public Node() {
      s = new Stack<>();
      next = null;
      length = 0;
    }
  }

  public void push(Item item) {

    // initial a single stack
    if (singleStack == null) {
      singleStack = new Node();
      count = 1;
      lastSingleStack = new Node();
      updateLastSingleStack(singleStack); // lastest pointer
    }

    // create anther new single stack when current stack is full
    if (singleStack.length == CAPACITY) {
      Node node = new Node();
      node.next = singleStack;
      singleStack = node;
      updateLastSingleStack(singleStack); // update latest pointer
      ++count;
    }
    singleStack.s.push(item);
    singleStack.length++;
  }

  public Item pop() {
    if (singleStack == null) {
      throw new NoSuchElementException("No element to pop");
    }
    Item item = singleStack.s.pop();
    singleStack.length--;

    // if no items in a single stack, set it to null or next single stack
    if (singleStack.length == 0) {
      singleStack = singleStack.next;
      updateLastSingleStack(singleStack); // update latest pointer
      --count;
    }
    return item;
  }

  // pop a item from a specific sub-stack
  public Item popAt(int index) {
    // valite for count
    if ( index == 0 || index > count) {
      throw new NoSuchElementException("Countn't find the specific sub stack, index maybe wrong");
    }

    // move to the specific stack
    for (int i = 1; i < index; i++) {
      singleStack = singleStack.next;
    }

    Item item = this.pop();
    shift(); // need to shift element after pop();
    return item;
  }

  //after pop from specific sub-stack , need to fill the empty position. Shift, ex ,Stack 3 -> Stack 2, Stack 2 -> Stack 1
  private void shift() {
    //temporally stack to store items for shifting.
    Stack<Item> stackForShift = new Stack<>();
    
    Node curr = lastSingleStack.next; //pointer to latest single stack, cuz at this moment, "singleStack" is point to the specfic stack.
    
    //Load items into stackForShift
    while (curr != singleStack) {
      stackForShift.push(curr.s.pop());
      curr.length--;
      if (curr.length == 0 && curr.next != null) {
        curr = curr.next;
      }
    }
    
    //load items from stackForShift
    while (!stackForShift.isEmpty()) {
      this.push(stackForShift.pop());
    }
  }

  // maintaining a node point, whose next is the latest single stack
  public void updateLastSingleStack(Node singleStack) {
    this.lastSingleStack.next = singleStack;
  }

  //print stack
  public void print() {
    int i = 1;
    while (singleStack != null) {
      System.out.println("-----------------------");
      System.out.println("SingleStack: " + i++ + " Length: " + singleStack.length);
      for (Item item : singleStack.s) {
        System.out.println(item);
      }
      singleStack = singleStack.next;
    }
    singleStack = lastSingleStack.next; //reset pointer after print
  }

  public static void main(String[] args) {
    Q3_3_SetOfStacks<Integer> stacks = new Q3_3_SetOfStacks<>();
    stacks.push(1);
    stacks.push(2);
    stacks.push(3);
    stacks.push(4);
    stacks.push(5);
    stacks.push(6);
    stacks.push(7);
    stacks.push(8);
    stacks.push(9);
    stacks.push(10);
    System.out.println();
    stacks.print();

    System.out.println();
    stacks.popAt(2);
    stacks.print();

    System.out.println();
    stacks.pop();
    stacks.pop();
    stacks.pop();
    stacks.pop();
    stacks.popAt(1);
    stacks.pop();
    stacks.pop();
    stacks.pop();
    stacks.pop();
    stacks.print();
    stacks.push(123231);
    System.out.println();
    stacks.print();
    
    System.out.println();
    stacks.popAt(0);
    stacks.print();
  }
}
