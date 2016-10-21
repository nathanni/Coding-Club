package com.nathan.multithreading.demo10_reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nathan on 10/20/2016.
 */
public class Runner {

    private int count = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();

        System.out.println("Waiting ...");
        condition.await();

        System.out.println("Woken up!");
        //increment(); //if throws expection, next line next execute
        try {
            increment();
        } finally {
            lock.unlock();
        }

    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");

        condition.signal();
        //increment(); //if throws expection, next line next execute
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finish() {
        System.out.println("Count is: " + count);
    }
}
