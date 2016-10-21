package com.nathan.multithreading.demo13_callable_future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Nathan on 10/21/2016.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {

                    Random random = new Random();
                    int duration = random.nextInt(4000);
                    if (duration > 2000) {
                        throw new IOException("Sleeping too long..");
                    }



                    System.out.println("Start ...");

                    try {
                        Thread.sleep(duration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Finished ...");
                    return duration;
                }
            });
            try {
                System.out.println("Result is: " + future.get()); //blocking waiting the future is finished
            } catch (ExecutionException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        executor.shutdown();
        //executor.awaitTermination(1, TimeUnit.DAYS);




    }
}
