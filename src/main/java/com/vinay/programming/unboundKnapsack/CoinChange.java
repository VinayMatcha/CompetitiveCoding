package com.vinay.programming.unboundKnapsack;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] denominations = new int[] { 2, 3, 5, 9};
        int amount =  151;
        System.out.println(coinChange.bruteForceMethod(denominations, amount, 0));
        System.out.println(coinChange.memorizationMethod(denominations, amount, 0, new Integer[denominations.length][amount+1]));
        System.out.println(coinChange.dynamicMethod(denominations, amount));
    }

    public int dynamicMethod(int[] denominations, int amount) {
        int[][] dp = new int[denominations.length][amount+1];
        for (int i=0;i<denominations.length;i++)
            dp[i][0] = 1;
        for (int i=1;i<=amount;i++)
//            if (i % denominations[0] == 0)
//                dp[0][i] = 1;
            if (denominations[0] <= i){
                dp[0][i] += dp[0][i-denominations[0]];
            }
        for (int i=1;i<denominations.length;i++) {
            for (int j=1;j<=amount;j++) {
                if (denominations[i] <= j){
                    dp[i][j] += dp[i][j-denominations[i]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[denominations.length-1][amount];
    }


    public int memorizationMethod(int[] denominations, int amount, int currentIndex, Integer[][] dp) {
        if (amount == 0)
            return 1;
        if (denominations.length == 0 || currentIndex >= denominations.length)
            return 0;
        if (dp[currentIndex][amount] == null) {
            int count = 0;
            if (denominations[currentIndex] <= amount)
                count += this.bruteForceMethod(denominations, amount-denominations[currentIndex], currentIndex);
            count += this.bruteForceMethod(denominations, amount, currentIndex+1);
            dp[currentIndex][amount] =  count;
        }
        return dp[currentIndex][amount];
    }

    public int bruteForceMethod(int[] denominations, int amount, int currentIndex) {
        if (amount == 0)
            return 1;
        if (denominations.length == 0 || currentIndex >= denominations.length)
            return 0;

        int count = 0;
        if (denominations[currentIndex] <= amount)
            count += this.bruteForceMethod(denominations, amount-denominations[currentIndex], currentIndex);
        count += this.bruteForceMethod(denominations, amount, currentIndex+1);
        return count;
    }

}
