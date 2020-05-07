package com.vinay.practice;

public class KSumArray {

    public static int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int sum[] = new int[K];
        int curSum = 0;
        for(int i: A){
            curSum += i;
            int r = Math.floorMod(curSum, K);
            sum[r]++;
        }
        for(int i=0;i<K;i++){
            if(sum[i]>0){
                res += ((sum[i]*(sum[i]-1))/2);
            }
        }
        res += sum[0];
        return res;
    }

    public static void main(String[] args) {
        int A[] = new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(A, 5));
    }

}
