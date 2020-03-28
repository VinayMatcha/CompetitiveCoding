package com.vinay.programming.knapsack;

import java.util.Arrays;

public class BasicKnapsack {

    public static void main(String[] args) {
        BasicKnapsack basicKnapsack = new BasicKnapsack();
        int weights[] = new int[]{2, 3, 1, 4};
        int profits[] = new int[]{4, 5, 3, 7};
        int capacity = 5;
        int dp[][] = new int[weights.length][capacity+1];
        System.out.println(basicKnapsack.bruteForceMethod(weights, profits, capacity, 0));
        System.out.println(basicKnapsack.knapSackRecursive(weights, profits, capacity, 0, dp));
        System.out.println(basicKnapsack.bottomUpApproach(weights, profits, capacity, true));
        profits = new int[]{1, 6, 10, 16};
        weights = new int[]{1, 2, 3, 5};
        capacity = 7;
        dp = new int[weights.length][capacity+1];
        System.out.println(basicKnapsack.bruteForceMethod(weights, profits, capacity, 0));
        System.out.println(basicKnapsack.knapSackRecursive(weights, profits, capacity, 0, dp));
        System.out.println(basicKnapsack.bottomUpApproach(weights, profits, capacity, true));
        System.out.println(basicKnapsack.bottomUpApproachMemory(weights, profits, capacity, true));
        System.out.println("Task 1 is" + BasicKnapsack.solveKnapsack( profits, weights, capacity));

    }

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        //TODO: Write - Your - Code
        if (capacity <= 0 || profits.length <= 0)
            return 0;
        int dp[] = new int[capacity+1];
        int dp2[] = new int[capacity+1];
        for (int c=0;c<capacity+1;c++)
            if (weights[0] <= c)
                dp[c] = profits[0];
        for (int i=1;i<weights.length;i++) {
            for (int c=1;c<capacity+1;c++) {
                int profit1 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c-weights[i]];
                int profit2 = dp[c];
                dp2[c] = Math.max(profit1, profit2);
            }
            for (int j = 0; j < dp.length; j++) {
                dp[j] = dp2[j];
            }
        }
        return dp[capacity];
    }

    private int bottomUpApproachMemory(int[] weights, int[] profits, int capacity, boolean printSelectedItems) {
        if (capacity <= 0 || profits.length <= 0)
            return 0;
        int dp[] = new int[capacity+1];
        for (int c=0;c<capacity+1;c++)
            if (weights[0] <= c)
                dp[c] = profits[0];
        for (int i=1;i<weights.length;i++) {
            for (int c=capacity;c>0;c--) {
                int profit1 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c-weights[i]];
                int profit2 = dp[c];
                dp[c] = Math.max(profit1, profit2);
            }
        }
        return dp[capacity];
    }

    private int bottomUpApproach(int[] weights, int[] profits, int capacity, boolean printSelectedItems) {
        if (capacity <= 0 || profits.length <= 0)
            return 0;
        int dp[][] = new int[weights.length][capacity+1];
        for (int c=0;c<capacity+1;c++)
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        for (int i=1;i<weights.length;i++) {
            for (int c=1;c<capacity+1;c++) {
                int profit1 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                int profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        if (!printSelectedItems)
            printSelectedWeights(weights, profits, capacity, dp);
        return dp[weights.length-1][capacity];

    }


    private void printSelectedWeights(int[] weights, int[] profits, int capacity, int[][] dp) {
        System.out.print("Selected weights: \n");
        int totalProfit = dp[weights.length-1][capacity];
        for (int i=weights.length-1; i>0; i--) {
            if (totalProfit != dp[i-1][capacity]) {
                System.out.println("weights: " + weights[i] + " profits " + profits[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
        if (totalProfit != 0)
            System.out.println("weights: " + weights[0] + " profits" + profits[0]);
        System.out.println("completed");

    }

    private int knapSackRecursive(int[] weights, int[] profits, int capacity, int currentIndex, int[][] dp) {
        if (capacity <= 0 || profits.length <= currentIndex)
            return 0;
        if (dp[currentIndex][capacity] != 0)
            return dp[currentIndex][capacity];
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapSackRecursive(weights, profits, capacity-weights[currentIndex], currentIndex+1, dp);
        int profit2 = knapSackRecursive(weights, profits, capacity, currentIndex+1, dp);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }





    private int bruteForceMethod(int[] weights, int[] profits, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length <= currentIndex)
            return 0;
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + bruteForceMethod(weights, profits, capacity-weights[currentIndex], currentIndex+1);
        int profit2 = bruteForceMethod(weights, profits, capacity, currentIndex+1);
        return Math.max(profit1, profit2);
    }

}
