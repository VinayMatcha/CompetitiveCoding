package com.vinay.programming.knapsack;

public class MinimumSubsetSum {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 9};
        MinimumSubsetSum minimumSubsetSum = new MinimumSubsetSum();
        System.out.println(minimumSubsetSum.bruteForceMethod(arr, 0, 0, 0));
        System.out.println(minimumSubsetSum.memorizationMethod(arr));
        System.out.println(minimumSubsetSum.dynamicProgramming(arr));
        arr = new int[]{1, 2, 7, 1, 15};
        System.out.println(minimumSubsetSum.bruteForceMethod(arr, 0, 0, 0));
        System.out.println(minimumSubsetSum.memorizationMethod(arr));
        System.out.println(minimumSubsetSum.dynamicProgramming(arr));
    }

    public int dynamicProgramming(int[] arr) {
        int sum = 0;
        for (int a: arr)
            sum += a;
        boolean dp[][] = new boolean[arr.length][sum/2+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = true;
        for (int i=1;i<=sum/2;i++)
            dp[0][i] =arr[0] == i ? true : false;

        for (int i=1;i<arr.length; i++) {
            for (int s=1;s<=sum/2;s++) {
                if (arr[i] <= s){
                    dp[i][s] = dp[i-1][s-arr[i]];
                }
                dp[i][s] = dp[i-1][s] || dp[i][s];
            }
        }
        int sum1 = 0;
        for (int i=sum/2;i>=0;i--) {
            if (dp[arr.length-1][i]) {
                sum1 = i;
                break;
            }
        }
        return Math.abs(sum1-(sum-sum1));
    }

    public int memorizationMethod(int[] arr) {
        int sum = 0;
        for (int a: arr)
            sum += a;
        return this.memorizationMethodRecursive(arr, 0, 0, 0, new Integer[arr.length][sum+1]);
    }

    public int memorizationMethodRecursive(int[] arr, int currentIndex, int sum1, int sum2, Integer[][] dp) {
        if (currentIndex == arr.length)
            return Math.abs(sum1-sum2);
        if (dp[currentIndex][sum1] == null) {
            int diff1 = this.memorizationMethodRecursive(arr, currentIndex+1, sum1+arr[currentIndex], sum2, dp);
            int diff2 = this.memorizationMethodRecursive(arr, currentIndex+1, sum1, sum2+arr[currentIndex], dp);
            dp[currentIndex][sum1] =  Math.min(diff1, diff2);
        }
        return dp[currentIndex][sum1];
    }

    public int bruteForceMethod(int[] arr, int currentIndex, int sum1, int sum2) {
        if (currentIndex == arr.length)
            return Math.abs(sum1-sum2);

        int diff1 = this.bruteForceMethod(arr, currentIndex+1, sum1+arr[currentIndex], sum2);
        int diff2 = this.bruteForceMethod(arr, currentIndex+1, sum1, sum2+arr[currentIndex]);
        return Math.min(diff1, diff2);
    }



}
