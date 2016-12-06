package com.nathan.multithreading.udemy.demo14_interrupt;

import java.util.Random;

/**
 * Created by Nathan on 10/21/2016.
 */
public class App {
    public static void main(String[] args)  {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Random random = new Random();
                for (int i = 0; i < 1E10; i++) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                        break;
                    }

                    if(Thread.currentThread().isInterrupted() ) break;

                    Math.sin(random.nextDouble());

                }
            }
        });

        System.out.println("Start");
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");

    }
}
