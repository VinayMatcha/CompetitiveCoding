package com.vinay.dynamicProgramming.knapsack;

public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4, 8};
        int sum = 15;
        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.bruteForceMethod(arr, sum, 0));
        System.out.println(subsetSum.memorizationMethod(arr, sum, 0, new Boolean[arr.length][sum+1]));
        System.out.println(subsetSum.dynamicProgramming(arr, sum));
        System.out.println(subsetSum.dynamicProgrammingMemoryEfficient(arr, sum));
    }

    public boolean dynamicProgrammingMemoryEfficient(int[] arr, int sum) {
        if (!validSum(arr, sum))
            return false;
        boolean[] dp = new boolean[sum+1];
        for (int i=1;i<=sum;i++)
            if (arr[0] <= i )
                dp[i] = true;
        dp[0] = true;
        for (int i=1;i<arr.length;i++) {
            for (int s=sum; s>=0; s--) {
                if (!dp[s] && arr[i] <= s) {
                    dp[s] = dp[s-arr[i]];
                }
            }
        }
        return dp[sum];
    }

    public boolean validSum(int[] arr, int sum) {
        for (int a: arr)
            sum -= a;
        return sum <= 0 ? true: false;
    }

    public boolean dynamicProgramming(int[] arr, int sum) {
        if (!validSum(arr, sum))
            return false;
        boolean[][] dp = new boolean[arr.length][sum+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = true;
        for (int i=1;i<=sum;i++)
            if (arr[0] <= sum)
                dp[0][i] = true;

        for (int i=1;i<arr.length;i++) {
            for (int s=1; s<=sum; s++) {
                if (arr[i] <= s) {
                    dp[i][s] = dp[i-1][s-arr[i]];
                }
                dp[i][s] = dp[i][s] || dp[i-1][s];
            }
        }
        return dp[arr.length-1][sum];
    }

    public boolean memorizationMethod(int[] arr, int sum, int currentIndex, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (arr.length == 0 || arr.length <= currentIndex)
            return false;
        if (dp[currentIndex][sum] == null) {
            if (arr[currentIndex] <= sum && memorizationMethod(arr, sum-arr[currentIndex], currentIndex+1, dp)) {
                dp[currentIndex][sum] = true;
                return true;
            }
            dp[currentIndex][sum] = memorizationMethod(arr, sum, currentIndex+1, dp);
        }
        return dp[currentIndex][sum];
    }

    public boolean bruteForceMethod(int[] arr, int sum, int currentIndex) {
        if (sum == 0)
            return true;
        if (arr.length == 0 || arr.length <= currentIndex)
            return false;
        if (arr[currentIndex] <= sum && bruteForceMethod(arr, sum-arr[currentIndex], currentIndex+1))
            return true;
        return bruteForceMethod(arr, sum, currentIndex+1);
    }

}
