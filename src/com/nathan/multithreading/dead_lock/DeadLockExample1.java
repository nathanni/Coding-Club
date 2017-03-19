package com.nathan.multithreading.dead_lock;

/**
 * Created by nni on 12/6/2016.
 */
public class DeadLockExample1 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void f1() throws InterruptedException {
        synchronized (lock1) {

            Thread.sleep(1000);
            lock1.wait();
            synchronized (lock2) {
                System.out.println("f1");
                System.out.println("f11");
            }


        }
    }

    private void f2() throws InterruptedException {
        synchronized (lock2) {

            Thread.sleep(1000);
            synchronized (lock1) {
                System.out.println("f2");
                System.out.println("f22");
                lock1.notify();
            }
//            lock1.notifyAll();
//            lock2.wait();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockExample1 example1 = new DeadLockExample1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    example1.f1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    example1.f2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("end");
    }
}
