package com.nathan.leetcode.medium;

/**
 * Created by Nathan on 12/18/2015.
 */

/*  Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {

        int [] prices = {1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {

        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;




    }

}
