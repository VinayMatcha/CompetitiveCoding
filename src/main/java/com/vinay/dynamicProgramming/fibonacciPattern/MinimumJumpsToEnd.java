package com.vinay.dynamicProgramming.fibonacciPattern;

import java.util.Arrays;

public class MinimumJumpsToEnd {

    public static void main(String[] args) {
        MinimumJumpsToEnd minimumJumpsToEnd = new MinimumJumpsToEnd();
        int[] arr = new int[] {1,1,3,6,9,3,0,1,3};
        System.out.println(minimumJumpsToEnd.bruteForceMethod(arr, 0));
        System.out.println(minimumJumpsToEnd.memorizationMethod(arr, 0, new int[arr.length+1]));
        System.out.println(minimumJumpsToEnd.dynamicMethod(arr));
    }

    public int dynamicMethod(int[] arr) {
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=0;i<arr.length-1;i++) {
            for (int s=i+1; s<arr.length && s<= i+arr[i]; s++) {
                dp[s] = Math.min(dp[s], dp[i]+1);
            }
        }
        return dp[arr.length-1];
    }

    public int memorizationMethod(int[] arr, int currentIndex, int[] dp) {
        if (currentIndex == arr.length-1)
            return 0;
        if (arr[currentIndex] == 0)
            return Integer.MAX_VALUE;
        if (dp[currentIndex] == 0) {
            int minValue = Integer.MAX_VALUE;
            for (int i=currentIndex+1;i<=arr[currentIndex]+currentIndex && i<arr.length;i++) {
                int value = this.bruteForceMethod(arr, i);
                if (value != Integer.MAX_VALUE)
                    minValue = Math.min(minValue, value+1);
            }
            dp[currentIndex]=  minValue;
        }
        return dp[currentIndex];
    }

    public int bruteForceMethod(int[] arr, int currentIndex) {
        if (currentIndex == arr.length-1)
            return 0;
        if (arr[currentIndex] == 0)
            return Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i=currentIndex+1;i<=arr[currentIndex]+currentIndex && i<arr.length;i++) {
            int value = this.bruteForceMethod(arr, i);
            if (value != Integer.MAX_VALUE)
                minValue = Math.min(minValue, value+1);
        }
        return minValue;
    }

}
