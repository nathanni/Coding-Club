package com.nathan.multithreading.dead_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nni on 12/6/2016.
 */
public class DeadLockExample2 {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private int i = 0;

    public void aquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while (true) { //记住一定要用while(true), 没得到锁无限等待
            boolean getFirstLock = false;
            boolean getSecondLock = false;
            try {
                getFirstLock = firstLock.tryLock(); //会得到锁, count++
                getSecondLock = secondLock.tryLock(); //会得到锁, count++
            } finally {
                if (getFirstLock && getSecondLock) {
                    return;
                }
                if (getFirstLock) {
                    firstLock.unlock();
                }
                if (getSecondLock) {
                    secondLock.unlock();
                }
            }
            //Locks not acquired
            Thread.sleep(1);
        }
    }

    public void f1() {
        try {
            aquireLocks(lock1, lock2);
            lock2.lock(); //reentrant lock 是有count的, 加锁了几次就要解锁几次
            System.out.println("hah1");
            i++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock2.unlock();
            lock2.unlock();
        }
    }

    public void f2() {
        try {
            aquireLocks(lock1, lock2);
            lock1.lock(); //reentrant lock 是有count的, 加锁了几次就要解锁几次
            System.out.println("hah2");
            i++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock1.unlock();
            lock2.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DeadLockExample2 example2 = new DeadLockExample2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                example2.f1();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                example2.f2();

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(example2.i);
    }
}
