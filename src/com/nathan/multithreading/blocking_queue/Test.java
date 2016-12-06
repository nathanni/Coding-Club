package com.nathan.multithreading.blocking_queue;

/**
 * Created by nni on 12/6/2016.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Integer> queue = new BlockingQueue<>(10);



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    queue.enqueue(i++);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(queue.dequeue());
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("success");

    }
}
