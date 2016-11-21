package com.nathan.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by nni on 11/21/2016.
 */

class Process2 {
    int arrTime;
    int exeTime;

    public Process2(int arrTime, int exeTime) {
        this.arrTime = arrTime;
        this.exeTime = exeTime;
    }

}

public class Shortest_Job_First {
    public static void main(String[] args) {


        int[] req = {0, 0, 4};
        int[] dur = {5, 2, 2};
        System.out.println(solution(req, dur));
    }

    public static float solution(int[] req, int[] dur) {
        if (req == null || req.length == 0 || dur == null || dur.length == 0 || req.length != dur.length) return 0;

        int waitTime = 0;
        int len = req.length;
        int currTime = 0;
        int index = 0;

        Queue<Process2> heap = new PriorityQueue<>(len, new Comparator<Process2>() {

            @Override
            public int compare(Process2 o1, Process2 o2) {
                if (o1.exeTime == o2.exeTime) {
                    return o1.arrTime - o2.arrTime;
                }
                return o1.exeTime - o2.exeTime;
            }
        });

        while (!heap.isEmpty() || index < len) {
            if (!heap.isEmpty()) {

                Process2 process = heap.poll();
                waitTime += currTime - process.arrTime;
                currTime += process.exeTime;

                while (index < len && req[index] <= currTime) {
                    heap.offer(new Process2(req[index], dur[index]));
                    index++;
                }


            } else {
                currTime = req[index];
                heap.offer(new Process2(req[index], dur[index]));
                index++;
            }
        }

//
//        for (int i = 0; i < len; i++) {
//            heap.offer(new Process2(req[i], dur[i]));
//        }
//
//        while (!heap.isEmpty()) {
//            Process2 process = heap.poll();
//            waitTime += currTime - process.arrTime < 0 ? process.arrTime : currTime - process.arrTime;
//            currTime += process.exeTime;
//        }

        return (float) waitTime / len;


    }
}
