package com.vinay.programming.unboundKnapsack;

public class BasicUndbounded {

    public static void main(String[] args) {

        int weights[] = new int[] {1, 2, 3};
        int profits[] = new int[] {15, 20, 50};
        int capacity = 5;
        BasicUndbounded basicUndbounded = new BasicUndbounded();
        System.out.println(basicUndbounded.bruteForceMethod(weights, profits, capacity, 0));
        System.out.println(basicUndbounded.memorizationMethod(weights, profits, capacity, 0, new Integer[weights.length][capacity+1]));
        System.out.println(basicUndbounded.dynamicMethod(weights, profits, capacity, true));

    }

    public int dynamicMethod(int[] weights, int[] profits, int capacity, boolean printSelectedItems) {
        int[][] dp = new int[weights.length][capacity+1];
        for (int i=0;i<weights.length;i++)
            dp[i][0] = 0;
        for (int i=1;i<=capacity;i++) {
            if (weights[0] * i <= capacity )
                dp[0][i] = profits[0] * i;
            else
                break;
//            System.out.print(dp[0][i] + " ");
        }
//        System.out.println();
        for (int i=1;i<weights.length;i++) {
            for (int c=1;c<=capacity; c++) {
                if (weights[i] <= c)
                    dp[i][c] = profits[i] + dp[i][c-weights[i]];
                dp[i][c] = Math.max(dp[i][c], dp[i-1][c]);
//                System.out.print(dp[i][c] + " ");
            }
//            System.out.println();
        }
        if (printSelectedItems) {
            this.printSelectedItems(dp, profits, weights, capacity);
        }
        return dp[weights.length-1][capacity];
    }

    public void printSelectedItems(int[][] dp, int[] profits, int[] weights, int capacity) {
        System.out.println("Ptiniting selected items");
        int total = dp[weights.length-1][capacity];
        for (int i=weights.length-1;i>0;i--) {
            if (total != dp[i-1][capacity]) {
                System.out.println("weights: " + weights[i] + " profits " + profits[i]);
                total -= profits[i];
                capacity -= weights[i];
            }
        }
        if (total!= 0)
            System.out.println("weights: " + weights[0] + " profits" + profits[0]);
        System.out.println("completed");
    }

    public int memorizationMethod(int[] weights, int[] profits, int capacity, int currentIndex, Integer[][] dp) {
        if (currentIndex >= profits.length || profits.length != weights.length || capacity <= 0)
            return 0;
        if (dp[currentIndex][capacity] == null) {
            int profit = 0;
            if (weights[currentIndex] <= capacity)
                profit = profits[currentIndex] + this.memorizationMethod(weights, profits, capacity-weights[currentIndex], currentIndex, dp);

            int profit2 = this.memorizationMethod(weights, profits, capacity, currentIndex+1, dp);
            dp[currentIndex][capacity] =  Math.max(profit, profit2);
        }
        return dp[currentIndex][capacity];
    }

    public int bruteForceMethod(int[] weights, int[] profits, int capacity, int currentIndex) {
        if (currentIndex >= profits.length || profits.length != weights.length || capacity <= 0)
            return 0;

        int profit = 0;
        if (weights[currentIndex] <= capacity)
            profit = profits[currentIndex] + this.bruteForceMethod(weights, profits, capacity-weights[currentIndex], currentIndex);

        int profit2 = this.bruteForceMethod(weights, profits, capacity, currentIndex+1);
        return Math.max(profit, profit2);
    }

}
