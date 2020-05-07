package com.vinay.practice;

import java.util.Arrays;

public class sol2 {
    public static int solution(int[] S, int[] E) {
        // write your code in Java SE 8
        Arrays.sort(S);
        Arrays.sort(E);
        int n = S.length;
        int res = 1;
        int check = 1;
        int i =0;
        int j =0;
        while(i < n && j < n){
            if(S[i] <= E[j]){
                check++;
                i++;
                if(check > res){
                    res = check;
                }
            }else{
                check--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 2, 6, 5, 3};
        int[] E = new int[]{5,5,7,6,8};
        System.out.println(solution(S, E));

    }
}
