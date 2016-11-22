package com.nathan.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Nathan on 11/22/16.
 */
class Point {
    double x;
    double y;

    public Point(double a, double b) {
        x = a;
        y = b;
    }
}

public class K_Closet_Points {
    public Point[] Solution(Point[] array, Point origin, int k) {

        if (array == null || array.length == 0 || origin == null || k <= 0 || k > array.length) return new Point[]{};

        Queue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double d1 = cal(o1, origin);
                double d2 = cal(o2, origin);
                if (d1 == d2) return 0;
                else if (d1 < d2) return 1;
                else return -1;
            }
        });

        Point[] res = new Point[k];
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                heap.offer(array[i]);
            } else {
                double d = cal(array[i], origin);
                if (d < cal(heap.peek(), origin)) {
                    heap.poll();
                    heap.offer(array[i]);
                }
            }
        }

        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll();
        }
        return res;


    }

    public double cal(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) - (p1.y - p2.y) * (p1.y - p2.y));
    }
}
