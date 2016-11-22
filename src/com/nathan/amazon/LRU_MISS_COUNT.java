package com.nathan.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 11/21/16.
 */
public class LRU_MISS_COUNT {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4, 1, 3, 2};
        System.out.println(solution(arr, 4));
    }

    public static int solution(int[] arr, int size) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> list = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                list.remove(new Integer(arr[i]));
            } else {
                count++;

                if (size == list.size()) {
                    list.remove(0);
                }
            }
            list.add(arr[i]);
        }
        return count;
    }
}
