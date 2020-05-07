package com.vinay.codeChef;

import java.util.Scanner;

public class March1 {


    public static void main(String[] args) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int baskets[] = new int[n];
                int prices[] = new int[n];
                int[] totCost = new int[m+1];
                for(int i=0;i<n;i++) {
                    baskets[i] = sc.nextInt();
                }
                for(int i=0;i<n;i++) {
                    prices[i] = sc.nextInt();
                    totCost[baskets[i]] += prices[i];
                }
                int max = Integer.MAX_VALUE;
                for(int i=0;i<=m;i++) {
                    if(max > totCost[i] && totCost[i]!=0) {
                        max = totCost[i];
                    }
                }
                System.out.println(max);
            }

        } catch(Exception e) {
            return;
        }



    }

}
