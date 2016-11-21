package com.nathan.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nni on 11/21/2016.
 */
public class Maze {

    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;

        if (matrix[0][0] == 9) return 1;
        if (matrix[0][0] == 1) return 0;

        int m = matrix.length, n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        matrix[0][0] = 1;
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir: dirs) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (matrix[newX][newY] == 9) return 1;
                    else if (matrix[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                        matrix[newX][newY] = 1;
                    }
                }
            }

        }
        return 0;

    }
}
