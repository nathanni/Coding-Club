package com.nathan.amazon;
import java.util.Scanner;

public class Stock_Maximize {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine().trim());

        while (testCases-- > 0) {
            int len = Integer.parseInt(sc.nextLine().trim());
            int[] prices = new int[len];
            String s= sc.nextLine();
            String[] sArr = s.trim().split("\\s");

            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(sArr[i]);
            }

            int maxPrice = prices[prices.length - 1];
            long maxProfit = 0;
            for (int i = prices.length - 1; i >= 0; i--) {
                maxPrice = Math.max(maxPrice, prices[i]);

                maxProfit += maxPrice - prices[i];
            }
            System.out.println(maxProfit);
        }

    }
}