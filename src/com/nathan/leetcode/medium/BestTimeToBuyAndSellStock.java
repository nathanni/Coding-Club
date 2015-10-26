package com.nathan.leetcode.medium;

/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/


public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    
    int maxProfit = 0;
    int temp = 0;
    for(int i = 0; i < prices.length; i++) {
      if(i == 0) {
        temp = prices[0];
      } else {
        if(prices[i] <= temp) {
          temp = prices[i];
        } else {
          maxProfit = Math.max(maxProfit, prices[i] - temp);
        }
      }
    }
    
    return maxProfit;
  }
}
