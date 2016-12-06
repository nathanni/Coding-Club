package com.nathan.multithreading.counter;

/**
 * Created by Nathan on 12/4/16.
 */
public class Counter1 {

    private int count;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }
    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

}
