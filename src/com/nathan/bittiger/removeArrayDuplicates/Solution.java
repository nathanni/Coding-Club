package com.nathan.bittiger.removeArrayDuplicates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nathan on 9/17/2016.
 */
public class Solution {

    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int index = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != prev) {
                arr[index++] = arr[i];
                prev = arr[i];
            }

        }

        return index;


    }

    public static int removeDuplicates2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return 0;

        int prev = arr[0];
        int index = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                if (count < k) {
                    arr[index++] = arr[i];
                }
                count++;
            } else {
                arr[index++] = arr[i];
                prev = arr[i];
                count = 1;
            }
        }

        return index;


    }

    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/removeArrayDuplicates/input"));

        int n =sc.nextInt();
        while (n != -1) {

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                arr[i] = num;
            }

            for(int num : arr) {
                System.out.print(num);
            }

            System.out.println();
            int last = removeDuplicates2(arr, 2);
            for (int i = 0; i < last; i++) {
                System.out.print(arr[i]);
            }

            n = sc.nextInt();
        }

        sc.close();
    }
}
