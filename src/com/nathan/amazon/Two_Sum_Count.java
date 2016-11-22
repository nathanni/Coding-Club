package com.nathan.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Nathan on 11/22/16.
 */
public class Two_Sum_Count {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 4, 5, 1};
//        int target = 6;
        int[] nums = {1,1,2,3,4};
        int target = 5;
        System.out.println(twoSumCount(nums, target));
        System.out.println(count1(nums, target));
        System.out.println(count2(nums, target));
        System.out.println(twoSumCount2(nums, target));

    }

    public static int twoSumCount(int[] nums, int target) {
        if (nums == null || nums.length < 2) return 0;


        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int n : nums) {
            if (set.contains(target - n)) {
                count++;
            }
            set.add(n);
        }
        return count;




    }

    public static int count1(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int cnt = 0;
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(target - nums[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int count2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i != map.get(target - nums[i])) {
                    cnt++;
                    map.remove(nums[i]);
                    map.remove(target - nums[i]);
                }
            }
        }
        return cnt;
    }

    public static int twoSumCount2(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                count += map.get(target - nums[i]);
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        return count;
    }

}
