package com.nathan.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nathan on 7/10/17.
 */
public class TestVolatile {

    private volatile int count;
    private AtomicInteger i = new AtomicInteger();

    public void increment() throws InterruptedException {
//        //while (true) {
//
//        for (int i = 0; i < 111111; i++) {
//            count++;
//            this.i.incrementAndGet();
//            //Thread.sleep(1);
//        }
//        //}

        while (true) {
            count++;
            //System.out.println(count);
            if (count == 100)break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile instance = new TestVolatile();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(instance.count);
        System.out.println(instance.i);

    }
}
