package com.nathan.multithreading.udemy.demo9_cpmodel;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Nathan on 10/20/2016.
 */
public class Processor {
    private Object lock = new Object();
    private LinkedList<Integer> list = new LinkedList<>();
    private static final int LIMIT = 10;
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(++value);
                System.out.println("Produce: " + value + "; List size: " + list.size());
                lock.notify();
            }
        }
    }
    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                int value = list.removeFirst();
                System.out.println("Consume: " + value + "; List size: " + list.size());
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}
