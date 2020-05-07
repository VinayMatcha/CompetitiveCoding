package com.vinay.programming.fibonacciPattern;

public class MinimumJumpsWithFee {

    public static void main(String[] args) {
        int fee[] = new int[] {1,2,5,2,1,2};
        int stairsCount = 6;
        MinimumJumpsWithFee minimumJumpsWithFee = new MinimumJumpsWithFee();
        System.out.println(minimumJumpsWithFee.bruteForceMethod(fee, stairsCount, 0));
        System.out.println(minimumJumpsWithFee.memorizationMethod(fee, stairsCount, 0, new int[stairsCount]));
        System.out.println(minimumJumpsWithFee.dynamicMethod(fee, stairsCount));
    }

    public int dynamicMethod(int[] fee, int stairsCount) {
        int dp[] = new int[stairsCount+1];
        dp[0] = 0;
        dp[1] = fee[0];
        dp[2] = fee[0];
        dp[3] = fee[0];
        for (int i=4;i<=stairsCount;i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int s=1;s<=3;s++) {
                dp[i] = Math.min(dp[i], dp[i-s]+fee[i-s]);
            }
        }
        return dp[stairsCount];
    }

    public int memorizationMethod(int[] fee, int stairsCount, int currentIndex, int[] dp) {
        if (currentIndex > stairsCount-1)
            return 0;

        if (dp[currentIndex] == 0) {
            int totalFee = Integer.MAX_VALUE;
            for (int i=1;i<=3;i++) {
                int value = this.bruteForceMethod(fee, stairsCount, currentIndex+i);
                if (value != Integer.MAX_VALUE) {
                    totalFee = Math.min(value+fee[currentIndex], totalFee);
                }
            }
            dp[currentIndex] =  totalFee;
        }
        return dp[currentIndex];
    }

    public int bruteForceMethod(int[] fee, int stairsCount, int currentIndex) {
        if (currentIndex > stairsCount-1)
            return 0;
        int totalFee = Integer.MAX_VALUE;
        for (int i=1;i<=3;i++) {
            int value = this.bruteForceMethod(fee, stairsCount, currentIndex+i);
            if (value != Integer.MAX_VALUE) {
                totalFee = Math.min(value+fee[currentIndex], totalFee);
            }
        }
        return totalFee;
    }

}
