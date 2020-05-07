package com.vinay.dynamicProgramming.knapsack;

public class CountSubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 7, 1, 5};
        int sum = 9;
        CountSubsetSum countSubsetSum = new CountSubsetSum();
        System.out.println(countSubsetSum.bruteForceMethod(arr, sum, 0));
        System.out.println(countSubsetSum.memorizationMethod(arr, 0, sum, new Integer[arr.length][sum+1]));
        System.out.println(countSubsetSum.dynamicProgramming(arr, sum));
        System.out.println(countSubsetSum.dynamicProgrammingSpace(arr, sum));
    }

    public int dynamicProgrammingSpace(int[] arr, int sum) {
        int dp[] = new int[sum+1];
        for (int i=1;i<=sum;i++)
            dp[i] =arr[0] == i ? 1 : 0;
        dp[0] =1;
        for (int i=1;i<arr.length; i++) {
            for (int s=sum;s>=0;s--) {
                if (arr[i] <= s){
                    dp[s] += dp[s-arr[i]];
                }
            }
        }

        return dp[sum];
    }


    public int dynamicProgramming(int[] arr, int sum) {
        int dp[][] = new int[arr.length][sum+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = 1;
        for (int i=1;i<=sum;i++)
            dp[0][i] =arr[0] == i ? 1 : 0;

        for (int i=1;i<arr.length; i++) {
            for (int s=1;s<=sum;s++) {
                if (arr[i] <= s){
                    dp[i][s] = dp[i-1][s-arr[i]];
                }
                dp[i][s] += dp[i-1][s];
            }
        }

        return dp[arr.length-1][sum];
    }


    public int memorizationMethod(int[] arr, int currentIndex, int sum, Integer[][] dp) {
        if (sum == 0)
            return 1;
        if (currentIndex >= arr.length)
            return 0;
        if (dp[currentIndex][sum] == null) {
            int diff1 = 0;
            if (arr[currentIndex] <= sum)
                diff1 = this.memorizationMethod(arr, currentIndex+1, sum-arr[currentIndex], dp);
            int diff2 = this.memorizationMethod(arr, currentIndex+1, sum, dp);
            dp[currentIndex][sum] =  diff1 +  diff2;
        }
        return dp[currentIndex][sum];
    }

    public int bruteForceMethod(int[] arr, int sum, int currentIndex) {
        if (sum == 0)
            return 1;
        if (currentIndex >= arr.length|| sum < 0)
            return 0;
        int diff2 = 0;
        if (arr[currentIndex] <= sum)
            diff2 = this.bruteForceMethod(arr, sum-arr[currentIndex], currentIndex+1);
        int diff1 = this.bruteForceMethod(arr, sum, currentIndex+1);
        return diff1 + diff2;
    }

}
