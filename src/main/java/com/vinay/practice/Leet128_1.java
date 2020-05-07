package com.vinay.practice;

import java.util.Arrays;

public class Leet128_1 {
    public static int largestSumAfterKNegations(int[] A, int K) {
        if(A.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i] < 0 && K>0){
                A[i] = A[i]*(-1);
                K--;
            }
            min = Math.min(min, A[i]);
            sum += A[i];
        }
        System.out.println(min);
        if(K > 0 && K%2==1){
            if(min < 0){
                sum += (2 * min);
            }else {
                sum -= (2 * min);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int A[] = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(A, 6));
    }



}
