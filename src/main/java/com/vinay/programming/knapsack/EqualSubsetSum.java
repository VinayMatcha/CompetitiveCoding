package com.vinay.programming.knapsack;

public class EqualSubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4};
        EqualSubsetSum equalSubsetSum = new EqualSubsetSum();
        System.out.println(equalSubsetSum.bruteForceMethod(arr));
        System.out.println(equalSubsetSum.memorizationMethod(arr));
        System.out.println(equalSubsetSum.dynamicProgramming(arr));
    }

    public boolean dynamicProgramming(int[] arr) {
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }
        if (sum%2 !=0)
            return false;
        sum = sum/2;
        boolean dp[][] = new boolean[arr.length][sum+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = true;
        for (int i=1;i<=sum;i++)
            if (arr[0] <= sum)
                dp[0][i] = true;

        for (int i=1;i<arr.length;i++) {
            for (int j=1;j<= sum;j++) {
                if (arr[i] <= j){
                    dp[i][j] = dp[i-1][j-arr[i]];
                }
                else {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
            }
        }
        return dp[arr.length-1][sum];
    }

    public boolean memorizationMethod(int[] arr) {
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }
        if (sum%2 !=0)
            return false;
        Boolean[][] dp = new Boolean[arr.length][(sum/2)+1];
        return this.canPartitionMemorization(arr, sum/2, 0, dp);
    }

    public boolean canPartitionMemorization(int[] arr, int sum, int currentIndex, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (arr.length == 0 || arr.length <= currentIndex)
            return false;
        if (dp[currentIndex][sum] == null) {
            if (arr[currentIndex] <= sum && canPartitionMemorization(arr, sum-arr[currentIndex], currentIndex+1, dp)) {
                dp[currentIndex][sum] = true;
                return true;
            }
            dp[currentIndex][sum] = canPartitionMemorization(arr, sum, currentIndex+1, dp);
        }
        return dp[currentIndex][sum];
    }

    public boolean bruteForceMethod(int[] arr) {
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }
        if (sum%2 !=0)
            return false;
        return this.canPartitionRecursive(arr, sum/2, 0);
    }

    public boolean canPartitionRecursive(int[] arr, int sum, int currentIndex) {
        if (sum == 0)
            return true;
        if (arr.length == 0 || arr.length <= currentIndex)
            return false;
        if (arr[currentIndex] <= sum && canPartitionRecursive(arr, sum-arr[currentIndex], currentIndex+1))
            return true;
        return canPartitionRecursive(arr, sum, currentIndex+1);
    }

}
