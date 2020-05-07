package com.vinay.programming.unboundKnapsack;

public class MinimumCoinChange {

    public static void main(String[] args) {
        MinimumCoinChange minimumCoinChange = new MinimumCoinChange();
        int[] denominations = new int[] { 2, 3, 5, 9};
        int amount =  151;
        System.out.println(minimumCoinChange.bruteForceMethod(denominations, amount, 0));
        System.out.println(minimumCoinChange.memorizationMethod(denominations, amount, 0, new Integer[denominations.length][amount+1]));
        System.out.println(minimumCoinChange.dynamicMethod(denominations, amount));
    }

    public int dynamicMethod(int[] denominations, int amount) {
        int[][] dp = new int[denominations.length][amount+1];
        for (int i=0;i<denominations.length;i++) {
            for (int a=1;a<=amount;a++) {
                dp[i][a] = Integer.MAX_VALUE;
            }
        }

        for (int a=1;a<=amount;a++) {
            if (denominations[0] <= a && dp[0][a-denominations[0]]!= Integer.MAX_VALUE)
                dp[0][a] = dp[0][a-denominations[0]] + 1;
        }

        for (int i=1;i<denominations.length;i++) {
            for (int a=1;a<=amount;a++) {
                if (denominations[i] <= a && dp[i][a-denominations[i]]!= Integer.MAX_VALUE) {
                    dp[i][a] = dp[i][a-denominations[i]] + 1;
                }
                dp[i][a] = Math.min(dp[i][a], dp[i-1][a]);
            }
        }
        return dp[denominations.length-1][amount];

    }

    public int memorizationMethod(int[] denominations, int amount, int currentIndex, Integer[][] dp) {
        if (amount == 0)
            return 0;
        if (denominations.length <= currentIndex || amount <= 0)
            return Integer.MAX_VALUE;

        if (dp[currentIndex][amount] == null) {
            int count = Integer.MAX_VALUE;
            if (denominations[currentIndex] <= amount) {
                int res = this.bruteForceMethod(denominations, amount-denominations[currentIndex], currentIndex);
                if (res != Integer.MAX_VALUE)
                    count = res+1;
            }
            int count2 = this.bruteForceMethod(denominations, amount, currentIndex+1);
            dp[currentIndex][amount] =  Math.min(count, count2);
        }
        return dp[currentIndex][amount];
    }

    public int bruteForceMethod(int[] denominations, int amount, int currentIndex) {
        if (amount == 0)
            return 0;
        if (denominations.length <= currentIndex || amount <= 0)
            return Integer.MAX_VALUE;

        int count = Integer.MAX_VALUE;
        if (denominations[currentIndex] <= amount) {
            int res = this.bruteForceMethod(denominations, amount-denominations[currentIndex], currentIndex);
            if (res != Integer.MAX_VALUE)
                count = res+1;
        }
        int count2 = this.bruteForceMethod(denominations, amount, currentIndex+1);
        return Math.min(count, count2);
    }

}
