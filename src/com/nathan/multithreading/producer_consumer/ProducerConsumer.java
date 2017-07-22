package com.nathan.multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nni on 12/6/2016.
 */
public class ProducerConsumer {

    private LinkedList<Integer> list;
    private final int LIMIT;
    private Lock lock;
    private Condition empty;
    private Condition full;
    AtomicInteger item = new AtomicInteger();
    public ProducerConsumer(int size) {
        LIMIT = size;
        list = new LinkedList<>();
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void produce() {
        while (true) {
            try {
                lock.lock();
                while (list.size() == LIMIT) {
                    full.await();
                }
                int val = item.getAndIncrement();
                list.add(val);
                System.out.println("Produced: " + val + " List Size: " + list.size());
                empty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() {
        while (true) {
            try {
                lock.lock();
                while (list.size() == 0) {
                    empty.await();
                }
                int val = list.removeFirst();
                System.out.println("Consumed: " + val + " List Size: " + list.size());
                full.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
