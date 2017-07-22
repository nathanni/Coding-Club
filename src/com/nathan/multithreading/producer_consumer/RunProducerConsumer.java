package com.nathan.multithreading.producer_consumer;

/**
 * Created by nni on 12/6/2016.
 */
public class RunProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(20);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
