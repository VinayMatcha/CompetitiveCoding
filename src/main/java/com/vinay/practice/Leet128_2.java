package com.vinay.practice;

public class Leet128_2 {
    public static int clumsy(int N) {
        int sum = 0;
        boolean flag = true;
        while(N > 0){
            int mulDiv = N--;
            if(N > 0){
                mulDiv = mulDiv * (N--);
            }
            if(N > 0)
                mulDiv /= (N--);
            if(flag){
                sum += mulDiv;
                flag = false;
            }else {
                sum -= mulDiv;
            }
            if(N > 0){
                sum += N--;
            }
            System.out.println(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(2));
    }

}
