package com.vinay.practice;

public class AlternateDigit {
    public static void main(String[] args) {
        int number = 130;
        String value = String.valueOf(number);
        int length = value.length();
        StringBuilder newValue = new StringBuilder();
        for (int i=0;i<value.length()/2;i++) {
            newValue.append(value.charAt(i));
            newValue.append(value.charAt(length-i-1));
        }
        if (length%2 == 1)
            newValue.append(value.charAt(length/2));
        System.out.println(Integer.parseInt(newValue.toString()));
    }

    public static int maxSumTwoNoOverlap(int[] A, int K, int L) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = A[i] + preSum[i];
        }
        int lMax = preSum[K];
        int rMax = preSum[L];
        int res = preSum[K + L];
        for (int i = K + L ; i <= len; i++) {
            //case 1: L subarray is always before M subarray
            lMax = Math.max(lMax, preSum[i - L] - preSum[i - L - K]);
            //case 2: M subarray is always before L subarray
            rMax = Math.max(rMax, preSum[i - K] - preSum[i - L - K]);
            //compare two cases and update res
            res = Math.max(res, Math.max(lMax + preSum[i] - preSum[i - L], rMax + preSum[i] - preSum[i - K]));
        }
        return res;
    }

}
