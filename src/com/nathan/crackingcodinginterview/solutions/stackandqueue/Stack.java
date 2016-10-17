package com.nathan.crackingcodinginterview.solutions.stackandqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> implements Iterable<Item> {

  Node first;

  private class Node {
    Item item;
    Node next;

    Node(Item item) {
      this.item = item;
      next = null;
    }
  }

  public void push(Item item) {
    Node n = new Node(item);
    n.next = first;
    first = n;
  }

  public Item pop() {
    if (first == null) {
      throw new NoSuchElementException("Stack is empty");
    }

    Item item = first.item;
    first = first.next;
    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public Item peek() {
    if (first == null) {
      throw new NoSuchElementException("Stack is empty");
    }
    
    return first.item;

  }

  @Override
  public Iterator<Item> iterator() {
    return new stackIterator();
  }
  
  private class stackIterator implements Iterator<Item> {

    private Node current = first;
    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if(!hasNext())
        throw new NoSuchElementException("Stack is empty");
      Item item = current.item;
      current = current.next;
      return item;
    }
    
  }
  
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for(Item item:this) {
      s.append(item + " ");
    }
    return s.toString();
  }
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(2);
    stack.push(2);
    stack.push(23);
    stack.push(234);
    stack.push(21);
    
    System.out.println(stack);
  }
  

}
