package com.nathan.multithreading.udemy.demo9_cpmodel.practice;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Nathan on 12/5/2016.
 */
public class Processor {


    public static void main(String[] args) {

        Processor processor = new Processor();

        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.produce();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.consume();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.consume();
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.consume();
            }
        });


        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t0.join();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("end");
    }


    private LinkedList<Integer> list = new LinkedList<>();
    private final static int LIMIT = 10;
    private Object lock = new Object();
    public void produce(){
        int val = 0;

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(++val);
                System.out.println("Produced: " + val + " Current List Size is: " + list.size());
                lock.notifyAll();
                //lost wakeup
            }
        }
    }

    public void consume(){
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int val = list.removeFirst();
                System.out.println("Consumed: " + val + " Current List Size is: " + list.size());
                lock.notifyAll();
                //防止 lost wakeup
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
