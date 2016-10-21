package com.nathan.multithreading.demo7_blockqueue_cpmodel;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Nathan on 10/20/2016.
 */
public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
    private static  void producer() throws InterruptedException {

        while (true) {
            Integer value = new Random().nextInt(100);
            queue.put(value);
            //System.out.println("Produce Value: " + value + "; Queue Size: " + queue.size());
        }
    }

    private static   void consumer() throws InterruptedException {

        while (true) {
            Thread.sleep(100);
            if (new Random().nextInt(10) == 0) {

                Integer value = queue.take();
                System.out.println("Consume Value: " + value + "; Queue Size: " + queue.size());
            }
        }
    }

}
