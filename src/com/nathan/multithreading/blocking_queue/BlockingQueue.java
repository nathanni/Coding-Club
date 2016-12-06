package com.nathan.multithreading.blocking_queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nni on 12/6/2016.
 */
public class BlockingQueue<T> {

    private T[] items;
    int head;
    int tail;
    int count;
    private int capacity = 0;
    private Lock lock;
    private Condition empty;
    private Condition full;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        items = (T[])new Object[capacity];
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
        head = 0;
        tail = 0;
        count = 0;
    }

    public void enqueue(T t) {

        try {
            lock.lock();
            while (count == capacity) {
                full.await();
            }
            items[tail++] = t;
            count++;
            if (tail == items.length) {
                tail = 0;
            }
            empty.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() {
        T res = null;
        try {
            lock.lock();
            while (count == 0) {
                empty.await();
            }
            res = items[head++];
            count--;
            if (head == items.length) {
                head = 0;
            }
            full.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public String toString() {
        String s = "";
        for (int i = head; i < count; i++) {
            s += items[i % items.length].toString();
        }
        return s;
    }


}
