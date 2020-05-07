package com.vinay.practice;

public class sqrt {

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        long i = 0;
        long j = x;
        while(i + 1 < j){
            long mid = i + (j - i)/2;
            long ans = mid *  mid;
            if(ans < x){
                i =  mid;
            }else if(ans > x){
                j = mid;
            }else{
                return (int) mid;
            }
        }
        return (int)i;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 4, 6, 8, 55, 81, 90};
        for(int i:a)
            System.out.println(mySqrt(i));
        System.out.println(" hello ");
    }

}
