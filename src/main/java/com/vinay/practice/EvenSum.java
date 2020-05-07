package com.vinay.practice;

public class EvenSum {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                sum += A[i];
            }
        }
        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int a = A[s];
            int t = queries[i][1];
            if(Math.abs(a)%2 == 0 && Math.abs(t)%2==0){
                sum += t;
            }else if(a%2==1 && Math.abs(t)%2==1){
                sum += t;
            }else if(a%2==0 && Math.abs(t)%2==1){
                sum -= t;
            }
            A[s] += t;
            res[i] = sum;
        }
        return res;
    }

}
