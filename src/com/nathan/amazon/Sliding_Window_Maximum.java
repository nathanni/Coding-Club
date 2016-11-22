package com.nathan.amazon;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nni on 11/22/2016.
 */
public class Sliding_Window_Maximum {



    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new int[]{};

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {



            if (i >= k && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }


            deque.offerLast(i);


            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }


        }
        return res;



    }
}
