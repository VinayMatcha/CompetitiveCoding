package com.vinay.programming.unboundKnapsack;

public class MaximumRibbonCutting {

    public static void main(String[] args) {
        int[] ribbonLengths = new int[]{3, 5, 7};
        int totalLength = 13;
        MaximumRibbonCutting maximumRibbonCutting = new MaximumRibbonCutting();
        System.out.println(maximumRibbonCutting.bruteForceMethod(ribbonLengths, totalLength, 0));
        System.out.println(maximumRibbonCutting.memorizationMethod(ribbonLengths, totalLength, 0, new Integer[ribbonLengths.length][totalLength+1]));
        System.out.println(maximumRibbonCutting.dynamicMethod(ribbonLengths, totalLength));
    }

    public int dynamicMethod(int[] ribbonLengths, int totalLength) {
        int[][] dp = new int[ribbonLengths.length][totalLength+1];
        for (int i=0;i<ribbonLengths.length;i++) {
            for (int a=1;a<=totalLength;a++) {
                dp[i][a] = Integer.MIN_VALUE;
            }
        }

        for (int a=1;a<=totalLength;a++) {
            if (ribbonLengths[0] <= a && dp[0][a-ribbonLengths[0]]!= Integer.MIN_VALUE)
                dp[0][a] = dp[0][a-ribbonLengths[0]] + 1;
        }

        for (int i=1;i<ribbonLengths.length;i++) {
            for (int a=1;a<=totalLength;a++) {
                if (ribbonLengths[i] <= a && dp[i][a-ribbonLengths[i]]!= Integer.MIN_VALUE) {
                    dp[i][a] = dp[i][a-ribbonLengths[i]] + 1;
                }
                dp[i][a] = Math.max(dp[i][a], dp[i-1][a]);
            }
        }
        return dp[ribbonLengths.length-1][totalLength];

    }

    public int memorizationMethod(int[] ribbonLengths, int totalLength, int currentIndex, Integer[][] dp) {
        if (totalLength == 0)
            return 0;
        if (ribbonLengths.length <= currentIndex || totalLength <= 0)
            return Integer.MIN_VALUE;

        if (dp[currentIndex][totalLength] == null) {
            int count = Integer.MIN_VALUE;
            if (ribbonLengths[currentIndex] <= totalLength) {
                int res = this.bruteForceMethod(ribbonLengths, totalLength-ribbonLengths[currentIndex], currentIndex);
                if (res != Integer.MIN_VALUE)
                    count = res+1;
            }
            int count2 = this.bruteForceMethod(ribbonLengths, totalLength, currentIndex+1);
            dp[currentIndex][totalLength] =  Math.max(count, count2);
        }
        return dp[currentIndex][totalLength];
    }

    public int bruteForceMethod(int[] ribbonLengths, int totalLength, int currentIndex) {
        if (totalLength == 0)
            return 0;
        if (ribbonLengths.length <= currentIndex || totalLength <= 0)
            return Integer.MIN_VALUE;

        int count = Integer.MIN_VALUE;
        if (ribbonLengths[currentIndex] <= totalLength) {
            int res = this.bruteForceMethod(ribbonLengths, totalLength-ribbonLengths[currentIndex], currentIndex);
            if (res != Integer.MIN_VALUE)
                count = res+1;
        }
        int count2 = this.bruteForceMethod(ribbonLengths, totalLength, currentIndex+1);
        return Math.max(count, count2);
    }

}
