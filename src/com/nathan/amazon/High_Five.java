package com.nathan.amazon;

import java.util.*;

/**
 * Created by Nathan on 11/21/16.
 */

class Result {
    int id;
    int value;
    public Result(int id, int value) {
        this.id = id;
        this.value = value;
    }

}

public class High_Five {

    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }

    public static Map<Integer, Double> getHighFive(Result[] results) {
        if (results == null || results.length == 0) return new HashMap<>();

        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, List<Integer>> students = new HashMap<>();

        for (Result result : results) {
            int id = result.id;
            int value = result.value;
            if (students.containsKey(id)) {
                students.get(id).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                students.put(id, list);
            }
        }

        for (Integer id : students.keySet()) {
            List<Integer> values = students.get(id);

            Collections.sort(values, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            double avg = 0;
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += values.get(i);
            }
            avg = sum / 5.0;

            res.put(id, avg);

        }
        return res;



    }
}
