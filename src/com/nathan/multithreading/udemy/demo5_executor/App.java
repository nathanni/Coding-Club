package com.nathan.multithreading.udemy.demo5_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nathan on 10/20/2016.
 */

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}

public class App {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }



        System.out.println("All task submitted. ");
        executor.shutdown(); // not immediately
        try {

            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("All task completed. spent time: " + (end - start));

    }
}
