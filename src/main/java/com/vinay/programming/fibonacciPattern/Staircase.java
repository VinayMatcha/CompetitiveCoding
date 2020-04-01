package com.vinay.programming.fibonacciPattern;

public class Staircase {

    public static void main(String[] args) {
        int cases = 4;
        Staircase staircase = new Staircase();
        System.out.println(staircase.bruteForceMethod(cases));
        System.out.println(staircase.memorizationMethod(cases, new int[cases+1]));
        System.out.println(staircase.dynamicMethod(cases));
    }

    public int dynamicMethod(int cases) {
        int dp[] = new int[cases+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=cases;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[cases];
    }

    public int memorizationMethod(int cases, int[] dp) {
        if (cases == 0)
            return 1;
        if (cases == 1)
            return 1;
        if (cases == 2)
            return 2;
        if (dp[cases] == 0) {
            int takeStep = this.memorizationMethod(cases-1, dp);
            takeStep += this.memorizationMethod(cases-2, dp);
            takeStep += this.memorizationMethod(cases-3, dp);
            dp[cases] =  takeStep;
        }
        return dp[cases];
    }

    public int bruteForceMethod(int cases) {
        if (cases == 0)
            return 1;
        if (cases == 1)
            return 1;
        if (cases == 2)
            return 2;
        int takeStep = this.bruteForceMethod(cases-1);
        takeStep += this.bruteForceMethod(cases-2);
        takeStep += this.bruteForceMethod(cases-3);
        return takeStep;
    }

}
