package com.vinay.programming.knapsack;

public class TargetSum {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 7, 1};
        int sum = 9;
        TargetSum targetSum = new TargetSum();
        //can be coverted to count of subsetsum
        int findSum = targetSum.convertToCountSubset(arr, sum);
        CountSubsetSum countSubsetSum = new CountSubsetSum();
        System.out.println(countSubsetSum.dynamicProgrammingSpace(arr, findSum));
        System.out.println(targetSum.bruteForceMethod(arr, sum, 0));
    }

    public int convertToCountSubset(int[] arr, int sum) {
        int total = 0;
        for (int a: arr)
            total += a;
        return (total + sum)/2;
    }

    public int bruteForceMethod(int[] arr, int sum, int currentIndex) {
        if (currentIndex == arr.length && sum == 0)
            return 1;
        if (currentIndex >= arr.length)
            return 0;
        int diff2 = this.bruteForceMethod(arr, sum-arr[currentIndex], currentIndex+1);
        int diff1 = this.bruteForceMethod(arr, sum + arr[currentIndex], currentIndex+1);
        return diff1 + diff2;
    }


}
