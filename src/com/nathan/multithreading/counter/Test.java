package com.nathan.multithreading.counter;

/**
 * Created by Nathan on 12/4/16.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        Counter1 counter1 = new Counter1();
        Counter2 counter2 = new Counter2();
        Counter3 counter3 = new Counter3();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i  = 0; i < 10000; i++) {
                    counter3.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i  = 0; i < 10000; i++) {
                    counter3.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter3.getCount());
    }
}
