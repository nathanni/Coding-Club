package com.nathan.multithreading.demo8_wait_notify;

import java.util.Scanner;

/**
 * Created by Nathan on 10/20/2016.
 */
public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
//            while (true) {
//
//            }

            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Resumed. ");
        }
    }

    public void consume() throws InterruptedException {

//        Thread.sleep(2000);
//        synchronized (this) {
//            System.out.println("test");
//        }

        Scanner scanner = new Scanner(System.in);

        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed. ");
            notify();
            Thread.sleep(5000);
        }
    }
}
