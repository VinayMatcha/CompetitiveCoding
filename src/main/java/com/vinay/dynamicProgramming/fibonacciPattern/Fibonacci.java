package com.vinay.dynamicProgramming.fibonacciPattern;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.calculateFibonacci(5));
        System.out.println(fibonacci.calculateFibonacci(9));
        System.out.println(fibonacci.bottomUpApproach(5));
        System.out.println(fibonacci.bottomUpApproach(9));
    }

    public int calculateFibonacci(int n) {
        int memorize[] = new int[n+1];
        return calcuateFibanocciRecursive(memorize, n);
    }

    public int calcuateFibanocciRecursive(int[] memorize, int n) {
        if(n < 2 )
            return n;
        if(memorize[n]!=0)
            return memorize[n];
        memorize[n] = calcuateFibanocciRecursive(memorize, n-1) + calcuateFibanocciRecursive(memorize, n-2);
        return memorize[n];
    }

    public int bottomUpApproach(int n) {
        if(n==0)
            return 0;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
