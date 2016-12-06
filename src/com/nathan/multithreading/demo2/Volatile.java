package com.nathan.multithreading.demo2;

/**
 * Created by nni on 10/19/2016.
 */

class Processor extends Thread {
    public static int i ;
    public static boolean running2 = true;


    public  void run() {

        while (running2) {
            i++;
        }
    }

    public void shutdown() {
        running2 = false;
    }
}

public class Volatile {
    public  static boolean running = true;
    public static void main(String[] args) throws InterruptedException {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop ...");

        Thread.sleep(1000);
        proc1.shutdown();

    }

}
