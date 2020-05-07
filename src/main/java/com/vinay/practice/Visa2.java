package com.vinay.practice;

public class Visa2 {


    public static int consecutive(long num) {
        // Write your code here
        long res = num;
        int result = 1;
        long div = 3;
        while(num !=1 && div < res){
            int count = 0;
            while(num%div == 0) {
                num /= div;

                count++;
            }
            if(count !=0){
                result *= (count+1);
            }
            div += 2;
        }
        return result-1;
        }

    public static void main(String[] args) {
        System.out.println(consecutive(21));
    }

}
