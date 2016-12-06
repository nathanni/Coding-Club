package com.nathan.multithreading.demo11_deadlock;

/**
 * Created by Nathan on 12/5/16.
 */
public class ExampleDeadLock2 {

    Object obj1 = new Object();
    Object obj2 = new Object();

    public void f1() {
        synchronized (obj1) {
            System.out.println("haha1");
            try {
                Thread.sleep(3000);
            } catch (Exception e){}
            f2();
        }

    }

    public void f2() {
        synchronized (obj2) {
            System.out.println("haha2");
            try {
                Thread.sleep(3000);
            } catch (Exception e){}

            f1();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExampleDeadLock2 instance = new ExampleDeadLock2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                instance.f1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                instance.f2();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("success");
    }
}
