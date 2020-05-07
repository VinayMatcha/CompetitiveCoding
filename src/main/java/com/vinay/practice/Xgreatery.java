package com.vinay.practice;

public class Xgreatery {
    public static int brokenCalc(int x, int y) {
        int res = 0;
        while(y > x){
            y = y%2 !=0?y+1:y/2;
            res++;
        }
        return res+x-y;
    }



    public static void main(String[] args) {
        System.out.println(brokenCalc(1, 100));
    }
}
