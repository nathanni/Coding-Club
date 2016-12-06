package com.nathan.multithreading.philosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nathan on 12/5/16.
 */

class ChopStick {
    private Lock lock;

    public ChopStick() {
        this.lock = new ReentrantLock();
    }

    public void pickup() {
        lock.lock();
    }

    public void putdown() {
        lock.unlock();
    }
}

public class DiningPhilosophers extends Thread{
    private int bites = 10;
    private ChopStick left, right;

    public DiningPhilosophers(ChopStick left, ChopStick right) {
        this.left = left;
        this.right = right;
    }
    public void eat() {
        pickup();
        chow();
        putdown();
    }

    private void putdown() {
        this.right.putdown();
        this.left.putdown();
    }

    private void chow() {

    }

    private void pickup() {
        this.left.pickup();
        this.right.pickup();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChopStick left = new ChopStick();
        ChopStick right = new ChopStick();
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers(left, right);
        diningPhilosophers.start();
        diningPhilosophers.join();
        System.out.println("success!");

    }
}
