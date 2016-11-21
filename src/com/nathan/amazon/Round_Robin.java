package com.nathan.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nni on 11/21/2016.
 */
class Process {
    int arriveTime;
    int executeTime;

    public Process(int arriveTime, int executeTime) {
        this.arriveTime = arriveTime;
        this.executeTime = executeTime;
    }
}

public class Round_Robin {
    public static void main(String[] args) {
        int[] ATime = {0, 1, 14, 15};
        int[] ETime = {5, 2, 5, 2};
        System.out.println(solution(ATime, ETime, 3));
    }

    public static float solution(int[] ATime, int[] ETime, int q) {
        if (ATime == null || ATime.length == 0 || ETime == null || ETime.length == 0 || ATime.length != ETime.length)
            return 0;

        Queue<Process> queue = new LinkedList<>();

        int waitTime = 0;
        int len = ATime.length;
        int currTime = 0;
        int index = 0;

        while (!queue.isEmpty() || index < len) {
            if (!queue.isEmpty()) {
                Process process = queue.poll();
                waitTime += currTime - process.arriveTime;
                currTime += Math.min(q, process.executeTime);

                while (index < len && ATime[index] <= currTime) {
                    queue.offer(new Process(ATime[index], ETime[index]));
                    index++;
                }

                if (process.executeTime > q) {
                    queue.offer(new Process(currTime, process.executeTime - q));
                }


            } else {
                currTime = ATime[index];
                queue.offer(new Process(ATime[index], ETime[index]));
                index++;
            }
        }

        return (float) waitTime / len;


    }

    public static float solution2(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length <= 1 || Etime.length <= 1 || Atime.length != Etime.length)
            return 0;
        int len = Atime.length;
        // usequeue data structure to store every process
        Queue<Process> processList = new LinkedList<Process>();
        // crtTimeis total time from 0 till now, waitTime is total waiting time
        int crtTime = Atime[0], waitTime = 0;
        // addfirst process into the list
        processList.add(new Process(Atime[0], Etime[0]));
        // indexof all original process
        int index = 1;
        while (!processList.isEmpty()) {
            Process crtProcess = processList.poll();
            waitTime += crtTime - crtProcess.arriveTime;
            crtTime += crtProcess.executeTime < q ? crtProcess.executeTime : q;
            for (; index < len && Atime[index] <= crtTime; ++index)
                processList.add(new Process(Atime[index], Etime[index]));
            if (crtProcess.executeTime > q)
                processList.add(new Process(crtTime, crtProcess.executeTime - q));
        }
        return (float) waitTime / len;
    }
}
