package com.nathan.bittiger.calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nni on 9/21/2016.
 */
class Calculator {

    private int base = 0;

    class Node {
        Character val;
        int priority;

        public Node(Character val, int priority) {
            this.val = val;
            this.priority = priority;
        }
    }


    public int eval(String equation) {

        if (equation == null || equation.length() == 0) return 0;

        Deque<Node> operators = new LinkedList<>();
        Deque<Integer> operands = new LinkedList<>();

        int n = equation.length();

        for (int i = 0; i <= n; i++) {


            //非常重要 需要忽略空格
            if (i < n && equation.charAt(i) == ' ') {
                continue;
            }
            //operands
            else if (i < n && Character.isDigit(equation.charAt(i))) {
                int sum = equation.charAt(i) - '0';
                while (i + 1 < n && Character.isDigit(equation.charAt(i + 1))) {
                    sum = sum * 10 + equation.charAt(i + 1) - '0';
                    i++;
                }
                operands.push(sum);
                //operators
            } else {
                if (i < n && equation.charAt(i) == '(') base += 10;
                else if (i < n && equation.charAt(i) == ')') base -= 10;
                else {
                    int currPriority = i == n ? Integer.MIN_VALUE : getPriority(equation.charAt(i));
                    while (!operators.isEmpty() && currPriority <= operators.peek().priority) {
                        char operator = operators.pop().val;
                        int calRes = cal(operator, operands);
                        operands.push(calRes);
                    }

                    operators.push(i == n ? new Node('d', currPriority) : new Node(equation.charAt(i), currPriority));
                }
            }


        }
        return operands.isEmpty() ? 0 : operands.peek();
    }

    private int cal(char operator, Deque<Integer> operands) {
        if (operands.isEmpty() || operands.size() < 2) return Integer.MIN_VALUE;
        if (operator == '+') return operands.pop() + operands.pop();
        if (operator == '-') {
            int o1 = operands.pop();
            int o2 = operands.pop();
            return o2 - o1;
        }
        if (operator == '*') return operands.pop() * operands.pop();
        if (operator == '/') {
            int o1 = operands.pop();
            int o2 = operands.pop();
            return o2 / o1;
        }
        return Integer.MIN_VALUE;
    }

    private int getPriority(char c) {
        if (c == '+' || c == '-') return base + 1;
        if (c == '*' || c == '/') return base + 2;
        return Integer.MIN_VALUE;
    }
}


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/calculator/input"));


        String s = sc.nextLine();

        while (!s.equals("END")) {
            Calculator calculator = new Calculator();
            System.out.println(calculator.eval(s));
            s = sc.nextLine();
        }

        sc.close();
    }
}
