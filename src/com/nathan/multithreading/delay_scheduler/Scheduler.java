package com.nathan.multithreading.delay_scheduler;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nni on 12/6/2016.
 */
public class Scheduler {

    private Queue<Task> queue;
    private volatile boolean running;
    private final AtomicInteger id;
    private final Thread backgroundThread;

    public Scheduler() {
        queue = new PriorityQueue<>();
        running = true;
        id = new AtomicInteger(1);

        backgroundThread = new Thread(new backgroundRunning());
        backgroundThread.start();
    }


    public void schedule(Task t, long delay) {

        t.setId(id.getAndIncrement());
        t.setTimeToRun(System.currentTimeMillis() + delay);
        synchronized (this) {
            queue.offer(t);
            this.notifyAll();
        }


    }

    public void stop() {
        synchronized (this) {
            running = false;
            this.notifyAll();
        }
        try {
            backgroundThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tasks stop");


    }

    private class backgroundRunning implements Runnable {

        @Override
        public void run() {
            while(running) {
                synchronized (Scheduler.this) {
                    while (running && queue.isEmpty()) {
                        try {
                            Scheduler.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!running) {
                        break;
                    }

                    long now = System.currentTimeMillis();
                    if (queue.peek().getTimeToRun() <= now) {
                        Task t = queue.poll();
                        t.run();
                    } else {
                        try {
                            Scheduler.this.wait(queue.peek().getTimeToRun() - now);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(new Task(), 100000);
        scheduler.schedule(new Task(), 1000);
        scheduler.schedule(new Task(), 9000);

        Thread.sleep(1300);
        scheduler.stop();
    }
}

class Task implements Comparable<Task>{
    private int id;
    private long timeToRun;

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeToRun(long timeToRun) {
        this.timeToRun = timeToRun;
    }
    public long getTimeToRun() {
        return timeToRun;
    }

    public void run() {
        System.out.println("The " + id + " task is running!");
    }

    @Override
    public int compareTo(Task o) {
        if (this.timeToRun < o.timeToRun) return -1;
        else if (this.timeToRun == o.timeToRun) return 0;
        else return 1;
    }
}

