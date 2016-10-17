package com.nathan.crackingcodinginterview.solutions.stackandqueue;

/*How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time.*/
public class Q3_2_StackWithMin extends Stack<Integer>{
  
  public static void main(String[] args) {
    
    Q3_2_StackWithMin s = new Q3_2_StackWithMin();
    s.push(3);
    s.push(5);
    s.push(6);
    s.push(7);
    s.push(2);
    s.pop();
    System.out.println(s);
    System.out.println(s.min());
  }
  
  
  Stack<Integer> s2;
  
  public Q3_2_StackWithMin() {
    s2 = new Stack<>();
  }
  
  public void push(int value) {
    if(value < min()) {
      s2.push(value);
    }
    super.push(value);
    
  }
  
  public Integer pop() {
    int value = super.pop();
    if(value == min()) {
      s2.pop();
    }
    return value;
    
  }
  
  public int min() {
    if(s2.isEmpty()) {
      return Integer.MAX_VALUE; //error out
    }
    return s2.peek();
  }

}
