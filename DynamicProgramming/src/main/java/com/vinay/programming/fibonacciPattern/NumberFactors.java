package com.vinay.programming.fibonacciPattern;

public class NumberFactors {

    public static void main(String[] args) {
        int number = 4;
        NumberFactors numberFactors = new NumberFactors();
        System.out.println(numberFactors.bruteForceMethod(number));
        System.out.println(numberFactors.memorizationMethod(number, new int[number+1]));
        System.out.println(numberFactors.dynamicMethod(number));
    }

    public int dynamicMethod(int number) {
        int dp[] = new int[number+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i=4;i<=number;i++) {
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[number];
    }

    public int memorizationMethod(int number, int[] dp) {
        if (number == 0)
            return 1;
        if (number == 1)
            return 1;
        if (number == 2)
            return 1;
        if (number == 3)
            return 2;
        
        if (dp[number] == 0) {
            int subtract = this.bruteForceMethod(number-1);
            subtract += this.bruteForceMethod(number-3);
            subtract += this.bruteForceMethod(number-4);
            dp[number] =  subtract;
        }
        return dp[number];
    }

    public int bruteForceMethod(int number) {
        if (number == 0)
            return 1;
        if (number == 1)
            return 1;
        if (number == 2)
            return 1;
        if (number == 3)
            return 2;
        int subtract = this.bruteForceMethod(number-1);
        subtract += this.bruteForceMethod(number-3);
        subtract += this.bruteForceMethod(number-4);
        return subtract;
    }

}
