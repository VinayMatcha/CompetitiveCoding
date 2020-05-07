package com.vinay.practice;

import java.util.Arrays;

public class Perimeter {
    public static int largestPerimeter(int[] A) {
        if(A.length == 3){
            return checkTraingle(A[0], A[1], A[2]);
        }
        Arrays.sort(A);
        int max = 0;
        for(int i=A.length-1;i>=2;i--){
            if(A[i] < A[i-1] + A[i-2]){
                int value = A[i]+A[i-1]+A[i-2];
                if(max < value){
                    max = value;
                }
            }
        }
        return max;
    }

    public static int checkTraingle(int a, int b, int c){
        if (a + b <= c || a + c <= b || b + c <= a){
            return 0;
        }else{
            return a+b+c;
        }
    }


    public static void main(String[] args) {
        int A[] = new int[]{2,4,6,10,18};
        System.out.println(largestPerimeter(A));
    }


}
