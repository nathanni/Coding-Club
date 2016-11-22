package com.nathan.amazon;

import java.util.Arrays;

/**
 * Created by nni on 11/22/2016.
 */
class Container {
    public double first;
    public double second;

    public Container(double first, double second) {
        this.first = first;
        this.second = second;

    }
}


public class Find_Optimal_Weigh_Close_Two_Sum {
    public static void main(String[] args) {
        double capacity = 35;
        double[] weights = {10,24,30,9,19,23,7};

        Container container = findOptimalWeights(capacity,weights,weights.length);

        System.out.println(container.first);
        System.out.println(container.second);
    }



    public static Container findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        if (weights == null || weights.length == 0) return null;

        Arrays.sort(weights);

        int start = 0, end = weights.length - 1;
        double diff = Integer.MAX_VALUE;
        double first = 0;
        double second = 0;

        while (start < end) {
            if (weights[start] + weights[end] == capacity) {
                Container container = new Container(weights[start], weights[end]);
                return container;
            } else if (weights[start] + weights[end] < capacity) {

                if (Math.abs(weights[start] + weights[end] - capacity) < diff) {
                    first = weights[start];
                    second = weights[end];
                    diff = Math.abs(weights[start] + weights[end] - capacity);
                }

                start++;
            } else {
                end--;
            }
        }

        return new Container(first, second);

    }
}
