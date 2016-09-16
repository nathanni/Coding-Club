package com.nathan.bittiger.perfectSquares;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by nni on 9/15/2016.
 */
class PerfectSquares {

    static ArrayList<Integer> cache;
    HashMap<Integer, Integer> cache2;

    PerfectSquares() {
        cache = new ArrayList<>();
        cache.add(0);
        cache2 = new HashMap<>();
    }


    public int dfs(int n) {
        if (n <= 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = n; i > 0; i--) {
            if (i * i > n) continue;
            res = Math.min(res, 1 + dfs(n - i * i));
        }

        return res;
    }


    public int dp1(int n) {
        if (n <= 0) return 0;


        while (cache.size() <= n) {
            int m = cache.size();
            int curr = Integer.MAX_VALUE;
            for (int i = 1; i * i <= m; i++) {
                curr = Math.min(curr, cache.get(m - i * i) + 1);
            }
            cache.add(curr);

        }

        return cache.get(n);

    }
    public int dp2(int n) {
        if (n <= 0) return 0;

        if (cache2.containsKey(n)) return cache2.get(n);


        int[] f = new int[n + 1];

        int ceiling = (int) Math.pow(n, 0.5);
        if (ceiling * ceiling == n) return 1;


        for (int i = 1; i <= n; i++) {

            if (cache2.containsKey(i)) {
                f[i] = cache2.get(i);
                continue;
            } else {
                f[i] = i;
            }

            for (int j = 1; j * j <= i; j++) {
                if (f[i - j * j] == 1) {
                    f[i] = 2;
                    break;
                } else {
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
                }
            }

            cache2.put(i, f[i]);

        }

        return f[n];
    }

    public int bfs(int n) {
        if (n <= 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        //queue.offer(-1);

        HashSet<Integer> used = new HashSet<>();

        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                int ceiling = (int) Math.pow(curr, 0.5);
                if (ceiling * ceiling == curr) return res;
                for (int j = ceiling; j > 0; j--) {
                    if (used.add(curr - j * j)) {
                        queue.offer(curr - j * j);
                    }
                }
            }
            res++;

        }
        return res;

    }
}

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        PerfectSquares perfectSquares = new PerfectSquares();

        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/perfectSquares/input"));

        int n = sc.nextInt();

        while (n != -1) {
            long start = System.nanoTime();
            System.out.print(n + "'s least perfect squares is " + perfectSquares.bfs(n));
            long end = System.nanoTime();
            System.out.println("   cost time: " + (end - start) / 1000000 + "ms");
            n = sc.nextInt();
        }

        sc.close();
    }
}
