package com.nathan.bittiger.perfectSquares;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nni on 9/15/2016.
 */
class PerfectSquares {


    public int dfs(int n) {
        if (n <= 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = n; i > 0; i--) {
            if (i * i > n) continue;
            res = Math.min(res, 1 + dfs(n - i *i));
        }

        return res;
    }


    public int least(int n) {
        if (n <= 0) return 0;


        int[] f = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            f[i] = i;

            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }

        }

        return f[n];
    }
}

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        PerfectSquares perfectSquares = new PerfectSquares();

        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/perfectSquares/input"));

        int n = sc.nextInt();

        while (n != -1) {
            long start = System.nanoTime();
            System.out.print(n +"'s least perfect squares is " +perfectSquares.dfs(n));
            long end = System.nanoTime();
            System.out.println("   cost time: " + (end - start) / 1000000 + "ms");
            n = sc.nextInt();
        }

        sc.close();
    }
}
