package com.nathan.crackingcodinginterview.solutions.stackandqueue;

public class Q3_2_StackWithMinNode extends Stack<NodeWithMin>{
  

  public static void main(String[] args) {
    Q3_2_StackWithMinNode s = new Q3_2_StackWithMinNode();
    s.push(3);
    s.push(5);
    s.push(6);
    s.push(7);
    s.push(2);
    s.pop();
    System.out.println(s);
    System.out.println(s.min());
  }
  
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for(NodeWithMin item:this) {
      s.append(item.value + " ");
    }
    return s.toString();
  }
  
  public void push(int value) {

    NodeWithMin node = null;
    if (super.isEmpty()) {
      node = new NodeWithMin(value, value);
    } else {
      if (value < min()) {
        node = new NodeWithMin(value, value);
      } else {
        node = new NodeWithMin(value, min());
      }
    }
    super.push(node);

    
  }
  
  public int min() {
    if(super.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return super.peek().min;
  }

  

}
