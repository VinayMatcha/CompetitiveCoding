package com.vinay.practice;

public class LeetCode126_4 {




    public static int mergeStones(int[] stones, int K) {
        int max = 0;
        int p = stones.length;
        if(stones.length < K){
            return -1;
        }
        int len = stones.length;
        if( len != K && (len-K)%(K-1)!=0){
            return -1;
        }
        while(!(len == 1)){
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<K;i++){
                sum += stones[i];
            }
            min = sum;
            int start = 0;
            for(int i=K;i<len;i++){
                sum = sum - stones[i - K] + stones[i];
                if(min >= sum){
                    min = sum;
                    start = i - K + 1;
                }
            }
            stones[start] = min;
            max += min;
            for(int i=start+1;i<=len-K;i++){
//                System.out.println("hello " + i + "  " + (i+K-1));
                stones[i] = stones[i+K-1];
            }
            len = len - K + 1;
            for(int i=0;i<len;i++){
                System.out.print(" " + stones[i]);
            }
            System.out.println(" max is "+ max);
        }
        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {
        int A[] = {4,6,4,7,5};
        int k = 2;
        mergeStones(A, k);
    }


}
