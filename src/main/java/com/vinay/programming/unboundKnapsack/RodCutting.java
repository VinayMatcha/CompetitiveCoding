package com.vinay.programming.unboundKnapsack;

public class RodCutting extends BasicUndbounded{

    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int capacity = 5;
        System.out.println(rodCutting.bruteForceMethod(lengths, prices, capacity, 0));
        System.out.println(rodCutting.memorizationMethod(lengths, prices, capacity, 0, new Integer[lengths.length][capacity+1]));
        System.out.println(rodCutting.dynamicMethod(lengths, prices, capacity, false));
    }

}
