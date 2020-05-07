package com.vinay.practice;

public class Leet128_3 {
    public int minDominoRotations(int[] A, int[] B) {
        int count[] = new int[6];
        int count1[] = new int[6];
        int row = A.length;
        int s = A[0];
        boolean flag = false;
        for(int i=0;i<A.length;i++){
            if(A[i] == B[i]){
                row--;
                if(!flag){
                    s = A[i];
                }else if(s!=A[i]){
                       return -1;
                }
            }else{
                count[A[i]-1]++;
                count1[B[i]-1]++;
            }
        }
        int check = A[0];
        for(int i=0;i<6;i++){
            if(count[i] + count1[i] >= row){
                check = i+1;
                flag = true;
                break;
            }
        }
        if(!flag){
            return -1;
        }else{
            int ans = A.length - (Math.max(count1[check-1], count[check-1]));
            return ans;
        }
    }
}
