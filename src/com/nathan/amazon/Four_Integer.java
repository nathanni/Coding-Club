package com.nathan.amazon;

import java.util.Arrays;

/**
 * Created by nni on 11/21/2016.
 */
public class Four_Integer {

    public int[] solution(int A, int B, int C, int D) {
        int[] res = new int[4];
        res[0] = A;
        res[1] = B;
        res[2] = C;
        res[3] = D;

        Arrays.sort(res);

        swap(res, 0, 1);
        swap(res, 2, 3);
        swap(res, 0 ,3);
        return res;
    }

    private void swap(int[] res, int i, int j) {
        int tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }
}
