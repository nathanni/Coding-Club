package com.nathan.leetcode.medium;

/**
 * Created by Nathan on 12/18/2015.
 */

/*Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
public class SingleNumberII {


    public int singleNumber1(int[] nums) {
        int[] bits = new int[32];
        int singleNumber = 0;

        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (((nums[j] >> i) & 1) != 0) {
                    ++bits[i];
                }
            }

            singleNumber |= (bits[i] % 3) << i;
        }

        return singleNumber;
    }

    /*
    对于除出现一次之外的所有的整数，其二进制表示中每一位1出现的次数是3的整数倍，将所有这些1清零，剩
下的就是最终的数。
用ones记录到当前计算的变量为止，二进制1出现“1次”（mod 3 之后的 1）的数位。用twos记录到当前计
算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的数位。当ones和twos中的某一位同时为1时表示
二进制1出现3次，此时需要清零。即用二进制模拟三进制计算。最终ones记录的是最终结果。
时间复杂度：O（n）*/

    public int singleNUmber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;

        for (int num : nums) {
            twos |= ones & num; //出现两次的 就加到B里面
            ones ^= num;   //从A里面删除 出现两次的
            threes = ones & twos; //如果是三次的 就会同时出现在A和B里面，
            ones &= ~threes;  //然后删除A里三次的
            twos &= ~threes;   //删除B里三次的
        }
        return ones;
    }
}
