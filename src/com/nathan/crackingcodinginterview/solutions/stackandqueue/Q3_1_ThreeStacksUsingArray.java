package com.nathan.crackingcodinginterview.solutions.stackandqueue;

import java.util.NoSuchElementException;

/*Describe how you could use a single array to implement three stacks.*/

public class Q3_1_ThreeStacksUsingArray {
  
  int stackSize = 100;
  int [] buffer = new int[stackSize * 3];
  int [] stackPointer = {-1,-1,-1}; //top index of each stack
  
  public boolean push(int stackNumber, int value) {
    if(stackPointer[stackNumber] +1 >= stackSize) {
      return false;
    }
    
    stackPointer[stackNumber] ++;
    buffer[getAbsTopOfStack(stackNumber)] = value;
    return true;
  }
  
  public int pop(int stackNumber) {
    if(stackPointer[stackNumber] == -1) {
      throw new NoSuchElementException("The stack is empty");
    }
    int num = buffer[getAbsTopOfStack(stackNumber)];
    buffer[getAbsTopOfStack(stackNumber)] = 0;
    stackPointer[stackNumber] -- ;
    return num;
  }
  
  int peek(int stackNum) {
    int index = getAbsTopOfStack(stackNum);
    return buffer[index];
  }
  
  public boolean isEmpty(int stackNumber) {
    return stackPointer[stackNumber] == -1;
  }
   
  //get the actual top of stack index in buffer[]
  int getAbsTopOfStack(int stackNumber) {
    return stackNumber * stackSize + stackPointer[stackNumber];
  }
  
  
  public void printStack(int stackNumber) {
    for(int i = stackNumber * stackSize; i <= getAbsTopOfStack(stackNumber); i++) {
      System.out.println(buffer[i]);
    }
  }

  public static void main(String[] args) {
    Q3_1_ThreeStacksUsingArray stack = new Q3_1_ThreeStacksUsingArray();
    stack.push(0, 123);
    stack.push(0, 1232);
    stack.push(0, 123123);
    stack.push(0, 12312354);
    stack.push(1, 123);
    stack.push(2, 123);
    stack.pop(0);
    stack.printStack(0);
    stack.printStack(1);
    
    
  }
}
