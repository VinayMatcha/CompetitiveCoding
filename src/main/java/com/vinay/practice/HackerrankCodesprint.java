package com.vinay.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HackerrankCodesprint {

    static int solve(List<Integer> a) {
        int sum = 0;
        int subsetSum;
        ArrayList<Integer> aa = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ara= new ArrayList<>();
        ara.add(aa);
        ara.add(b);
        ara.add(c);
        for(int i:a){
            sum+=i;
        }
        subsetSum = sum/3;
        if(a.size()==3 && a.get(0)==a.get(1)&& a.get(0)==a.get(2)){
            return 6;
        }
        if(sum%3!=0){
            return 0;
        }else{
            Collections.sort(a);
            int nums[] = new int[a.size()];
            int i =0;
            for(int num:a){
                nums[i++] = num;
            }
            if(subsetSum(nums, nums.length-1,subsetSum,subsetSum,subsetSum,ara)){
                return ara.get(0).size() * ara.get(1).size() * ara.get(2).size();
            }else{
                return 0;
            }
        }
    }

    public static boolean subsetSum(int[] S, int n, int a, int b, int c, ArrayList<ArrayList<Integer>> res){

        if(a ==0 && b==0 && c==0){
            return true;
        }
        if(n<0){
            return false;
        }
        boolean A = false;
        if(a - S[n] >=0){
            A = subsetSum(S, n-1, a-S[n],b, c, res);
            if(A){
                res.get(0).add(S[n]);
            }
        }
        boolean B = false;
        if(!A && b- S[n] >=0){
            B = subsetSum(S, n-1, a,b-S[n], c, res);
            if(B){
                res.get(1).add(S[n]);
            }
        }
        boolean C = false;
        if(!A && !B && c- S[n] >=0){
            C = subsetSum(S, n-1, a,b, c-S[n], res);
            if(C){
                res.get(2).add(S[n]);
            }
        }
        return A||B||C;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ai = new ArrayList<>();
        ai.add(1);
        ai.add(1);
        ai.add(1);
        ai.add(1);
        ai.add(1);
        System.out.println(solve(ai));
    }


}
