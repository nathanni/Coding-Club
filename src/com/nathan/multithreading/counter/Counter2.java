package com.nathan.multithreading.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nathan on 12/4/16.
 */
public class Counter2 {
    private int count;
    private Lock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }

    }
    public int getCount() {
        try {
            lock.lock();
            return count;
        } finally {
            lock.unlock();
        }
    }
}
