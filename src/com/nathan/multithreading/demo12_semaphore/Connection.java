package com.nathan.multithreading.demo12_semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Nathan on 10/21/2016.
 */
public class Connection {

    private Semaphore semaphore = new Semaphore(500, true);
    private static Connection instance = new Connection();

    private int connections = 0;

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            semaphore.release();
        }
    }

    public void doConnect() {

        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            connections--;
        }
        System.out.println("Connection released");

    }

}
