package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Great_Common_Divisor {
    public static void main(String[] args) {
        int[] arr = {44,88,8888};
        //System.out.println(solution(arr));

        System.out.println(gcd(3, 6));
    }

    public static int solution(int[] array){
        if (array == null || array.length == 0) return 0;

        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = gcd(res, array[i]);
        }
        return res;
    }

    private static int gcd(int a, int b) {


        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
