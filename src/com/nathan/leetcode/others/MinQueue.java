package com.nathan.leetcode.others;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by Nathan on 12/11/16.
 */
public class MinQueue {

    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();

    public void offer(int val) {
        queue.offer(val);

        while (!deque.isEmpty() && deque.peekLast() > val) {
            deque.pollLast();
        }
        deque.offer(val);
    }

    public int poll() {
        if (queue.isEmpty()) throw new NoSuchElementException();

        int res = queue.poll();
        if (!deque.isEmpty() && deque.peekFirst() == res) {
            deque.pollFirst();

        }
        return res;
    }

    public int min() {
        if (deque.isEmpty()) throw new NoSuchElementException();
        return deque.peekFirst();
    }

}
