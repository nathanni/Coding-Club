package com.nathan.findK;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nni on 9/21/2016.
 */
public class Solution {

    public static int kthSmallest(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return 0;

        int start = 0, end = nums.length - 1;
        k = k - 1;
        while (start < end) {
            int j = partition(nums, start, end);
            if (j == k) return nums[k];
            else if (j < k) {
                start = j + 1;
            } else {
                end = j - 1;
            }
        }

        return nums[k];


    }

    public static int partition(int[] nums, int left, int right) {

        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/findK/input"));

        int n = sc.nextInt();
        while (n != -1) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            while (m-- != 0) {
                System.out.println(kthSmallest(nums, sc.nextInt()));
            }

            n = sc.nextInt();

        }
    }
}
