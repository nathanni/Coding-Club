package com.nathan.bittiger.highestProduct;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Nathan on 9/17/2016.
 */
public class Solution {


    public static int highestProductOf3(int[] arr) {
        if (arr == null || arr.length < 3) return 0;

        Arrays.sort(arr);

        int res1 = arr[0] * arr[1] * arr[arr.length - 1];
        int res2 = arr[arr.length - 1] * arr[arr.length -2] * arr[arr.length -3];

        return Math.max(res1 , res2);

    }
    public static int highestProductOf3On(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(2, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int a: arr) {
            if (maxHeap.size() < 2 || a < maxHeap.peek()) {
                maxHeap.offer(a);
            }
            if (minHeap.size() < 3 || a > minHeap.peek()) {
                minHeap.offer(a);
            }
        }
        int res1 = 1;
        for (int i = 0; i < 2; i++) {
            res1 *= maxHeap.poll();
        }
        int res2 = 1;
        for (int i = 0; i < 2; i++) {
            res2 *= minHeap.poll();
        }

        res1 *=minHeap.peek(); res2 *= minHeap.poll();
        return Math.max(res1, res2);

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/highestProduct/input"));

        int n =sc.nextInt();

        while (n != -1) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(highestProductOf3On(arr));

            n = sc.nextInt();
        }

        sc.close();

    }
}
