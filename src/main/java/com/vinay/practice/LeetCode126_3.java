package com.vinay.practice;

public class LeetCode126_3 {


    public static int longestOnes(int[] A, int K) {
        int p = 0;
        int max = 0;
        while(p < A.length){
            int c = K;
            int count = 0;
            boolean flag = true;
            int oldP = p;
            for(int i=0;i<A.length;i++){
                if(A[i] == 0 && c > 0 && i > p){
                    c--;
                    count++;
                    if(flag && i > p){
                        p = i;
                        flag = false;
                    }
                }else if(A[i] == 1){
                    count++;
                }else{
                    if(flag && i > p){
                        p = i;
                        flag = false;
                    }
                    max = Math.max(count, max);
                    count = 0;
                }
            }
            if(p == oldP){
                break;
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        longestOnes(A, K);
    }


}
