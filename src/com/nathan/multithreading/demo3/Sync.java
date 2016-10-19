package com.nathan.multithreading.demo3;

/**
 * Created by nni on 10/19/2016.
 */
public class Sync {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        Sync sync = new Sync();
        sync.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

}


