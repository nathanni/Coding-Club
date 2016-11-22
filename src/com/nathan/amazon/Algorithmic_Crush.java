package com.nathan.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nni on 11/22/2016.
 */
class MyPoint implements Comparable<MyPoint>{
    int idx;
    int flag; //1 start 0 end
    int val;
    public MyPoint(int idx, int flag, int val) {
        this.idx = idx;
        this.flag = flag;
        this.val = val;
    }

    public int compareTo(MyPoint p) {
        if (this.idx == p.idx) {
            return p.flag - this.flag;
        }
        return this.idx - p.idx;
    }
}

public class Algorithmic_Crush {

    private static int max;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        String in = sc.nextLine();
        long max = 0;
        int len = 0;
        int operations  = 0;
        if (in != null) {
            String[] sArr = in.trim().split("\\s");
            len = Integer.parseInt(sArr[0]);
            operations = Integer.parseInt(sArr[1]);
        }

        List<MyPoint> points = new ArrayList<>();

        for (int i = 0; i < operations; i++) {
            in = sc.nextLine();
            String[] sArr = in.trim().split("\\s");
            points.add(new MyPoint(Integer.parseInt(sArr[0]), 1, Integer.parseInt(sArr[2])));
            points.add(new MyPoint(Integer.parseInt(sArr[1]), 0, Integer.parseInt(sArr[2])));
        }

        Collections.sort(points);
        long sum = 0;

        for (MyPoint point: points) {
            if (point.flag == 1) {
                sum += point.val;
            } else {
                sum -= point.val;
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);



    }


}
