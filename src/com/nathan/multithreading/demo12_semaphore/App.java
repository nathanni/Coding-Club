package com.nathan.multithreading.demo12_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nathan on 10/21/2016.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

//        Semaphore semaphore = new Semaphore(0);
//        semaphore.acquire();
//        semaphore.release();
//        System.out.println("Avalable permits: " + semaphore.availablePermits());



        ExecutorService exector = Executors.newCachedThreadPool();
        Connection conn = Connection.getInstance();
        for (int i = 0; i < 200; i++) {
            exector.submit(new Runnable() {
                @Override
                public void run() {
                    conn.connect();
                }
            });
        }

        exector.shutdown();

        exector.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("end");
    }
}
