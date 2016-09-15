package com.nathan.bittiger.happyNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by nni on 9/12/2016.
 */

class Happiness {

    HashMap<Integer, Boolean> cache;
    public Happiness() {
        cache = new HashMap<>();
        cache.put(1, true);
    }

    public boolean isHappyNumber(int num, int depth) {

        if (cache.containsKey(num)) {
            System.out.println("depth: " + depth + " to get the result");
            return cache.get(num);
        }

        cache.put(num, false); //每次都先把自己放入cache,默认为false, 最后再遇到自己或者中间变化过的数都时候就会返回false

        boolean result = isHappyNumber(transform(num), depth + 1);

        cache.put(num, result);
        return result;
    }

    public int transform(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }

        return res;
    }
}


public class Solution {



    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/happyNumber/input"));

        Happiness happiness = new Happiness();

        int n = sc.nextInt();


        //这里算是cache的preload
        for (int i = 2; i <= 810; i++) {
            happiness.isHappyNumber(i, 0);
        }


        while (n != -1) {
            System.out.println(happiness.isHappyNumber(happiness.transform(n), 1));
            n = sc.nextInt();
        }

        sc.close();
    }
}
