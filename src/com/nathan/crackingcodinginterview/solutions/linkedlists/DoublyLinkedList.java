package com.nathan.crackingcodinginterview.solutions.linkedlists;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<Item> implements Iterable<Item>{

  private int N;
  private Node head; //sentinal head
  private Node tail; //sentinal tail
  
  
  private class Node {
    Item item;
    Node prev;
    Node next;
    
    Node(Item item) {
      this.item = item;
    }
    public Node() {
    }
  }
  
  public DoublyLinkedList() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  public int length() {
    return N;
  }
  
  public void add(Item item) {
    Node node = new Node(item);
    Node last = tail.prev;
    node.next = tail;
    node.prev = last;
    tail.prev = node;
    last.next = node;
    ++N;
  }
  
  @Override
  public Iterator<Item> iterator() {
    return new DoublyLinkedListIterator();
  }
  
  private class DoublyLinkedListIterator implements ListIterator<Item> {

    private Node current = head.next;
    private Node lastAccessed = null;
    
    private int index = 0;
    
    @Override
    public boolean hasNext() {
      return index < N;
    }

    @Override
    public Item next() {
      if(!hasNext()) {
        throw new NoSuchElementException();
      }
      lastAccessed = current;
      Item item = current.item;
      current = current.next;
      ++index;
      return item;
      
    }

    @Override
    public boolean hasPrevious() {
      return index > 0;
    }

    @Override
    public Item previous() {
      if(!hasPrevious()) {
        throw new NoSuchElementException();
      }
      current = current.prev;
      Item item = current.item;
      lastAccessed = current;
      --index;
      return item;
    }

    @Override
    public int nextIndex() {
      return index;
    }

    @Override
    public int previousIndex() {
      return index - 1;
    }

    @Override
    public void remove() {
      if (lastAccessed == null) {
        throw new IllegalStateException();
      }
      Node x = lastAccessed.prev;
      Node y = lastAccessed.next;
      x.next = y;
      y.prev = x;
      N--;
      if (current == lastAccessed)
        current = y;
      else
        index--;
      lastAccessed = null;
    }
      

    @Override
    public void set(Item item) {
      if (lastAccessed == null) throw new IllegalStateException();
      lastAccessed.item = item;
      
    }

    @Override
    public void add(Item item) {
      Node x = current.prev;
      Node y = new Node(item);
      Node z = current;
      x.next = y;
      y.next = z;
      z.prev = y;
      y.prev = x;
      N++;
      index++;
      lastAccessed = null;
    }


    
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this)
      s.append(item + " ");
    return s.toString();
  }

}
