package com.nathan.multithreading.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nathan on 12/4/16.
 */
public class Counter3 {

    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();

    }
    public int getCount() {
        return count.get();
    }
}
