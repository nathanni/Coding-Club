package com.nathan.multithreading.demo1;

/**
 * Created by nni on 10/17/2016.
 */
public class HelloWorld {

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(new T1());
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t4: " + i);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("t1: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("t2: " + i);
        }
    }
}
