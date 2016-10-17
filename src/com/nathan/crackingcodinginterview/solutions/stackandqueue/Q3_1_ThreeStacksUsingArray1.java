package com.nathan.crackingcodinginterview.solutions.stackandqueue;

import java.util.NoSuchElementException;


// my draft implement
public class Q3_1_ThreeStacksUsingArray1 {
  
  int stackSize = 100;
  int [] buffer = new int[stackSize * 3];
  int [] stackIndex = new int[]{-1,-1,-1};
  
  void push(int stackNum, int value) {
    if(stackIndex[stackNum] + 1 >= stackSize) {
      return;
    }
    buffer[getAbsStackIndex(stackNum) + 1] = value;
    stackIndex[stackNum]++;
  }
  
  int pop(int stackNum) {
    if(stackIndex[stackNum] == -1) {
      throw new NoSuchElementException();
    }
    int value = buffer[getAbsStackIndex(stackNum)];
    buffer[getAbsStackIndex(stackNum)] = 0;
    stackIndex[stackNum]--;
    return value;
  }
  
  int getAbsStackIndex(int stackNum) {
    return stackNum *stackSize + stackIndex[stackNum];
  }
  
  void print(int stackNum) {
    for(int i = stackNum *stackSize; i < stackSize *(stackNum +1); i++) {
      if(buffer[i] != 0)
        System.out.println(buffer[i]);
    }
  }
  
  public static void main(String[] args) {
    Q3_1_ThreeStacksUsingArray1 stack3 = new Q3_1_ThreeStacksUsingArray1();

    stack3.push(0, 123);
    stack3.push(0, 123);
    stack3.push(0, 123);
    stack3.push(0, 123);
    stack3.print(0);
    stack3.print(1);
    stack3.print(2);
  }

}
