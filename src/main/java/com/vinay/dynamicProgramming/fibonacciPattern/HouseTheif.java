package com.vinay.dynamicProgramming.fibonacciPattern;

public class HouseTheif {

    public static void main(String[] args) {
        int[] housesWealth = new int[] {2, 10, 14, 8, 1};
        HouseTheif houseTheif = new HouseTheif();
        System.out.println(houseTheif.bruteForceMethod(housesWealth, 0));
        System.out.println(houseTheif.memorizationMethod(housesWealth, 0, new Integer[housesWealth.length+1]));
        System.out.println(houseTheif.dynamicMethod(housesWealth));
    }

    public int dynamicMethod(int[] housesWealth) {
        int[] dp = new int[housesWealth.length+1];
        dp[0] = 0;
        dp[1] = housesWealth[0];
        for (int i=1;i<housesWealth.length;i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+housesWealth[i]);
        }
        return dp[housesWealth.length];
    }

    public int memorizationMethod(int[] housesWealth, int currentIndex, Integer[] dp) {
        if (currentIndex > housesWealth.length-1)
            return 0;
        if (dp[currentIndex] == null) {
            int value = housesWealth[currentIndex] + bruteForceMethod(housesWealth, currentIndex+2);
            value = Math.max(value, this.bruteForceMethod(housesWealth, currentIndex+1));
            dp[currentIndex] = value;
        }
        return dp[currentIndex];
    }

    public int bruteForceMethod(int[] housesWealth, int currentIndex) {
        if (currentIndex > housesWealth.length-1)
            return 0;

        int value = housesWealth[currentIndex] + bruteForceMethod(housesWealth, currentIndex+2);
        value = Math.max(value, this.bruteForceMethod(housesWealth, currentIndex+1));
        return value;
    }
}
