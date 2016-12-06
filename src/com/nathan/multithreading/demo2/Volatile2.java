package com.nathan.multithreading.demo2;

/**
 * Created by Nathan on 12/5/2016.
 */
public class Volatile2 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        stopRequested = true;
    }
}
