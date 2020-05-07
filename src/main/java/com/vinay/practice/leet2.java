package com.vinay.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class leet2 {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList();
        TreeSet<Integer> set = new TreeSet();
        for(int i: A){
            set.add(i);
        }
        int find = set.last()+1;
        int r = A.length-1;
        while(!sortCheck(A) && r >=0){
            System.out.println("find is " +find);
            for(int ai:A){
                System.out.print(ai + " ");
            }
            find = set.floor(find-1);
            System.out.println();
            int i =0;
            while(A[i] != find){
                i++;
            }
            System.out.println("i and r " + i + " " + r);
            if(i!=r){
                if(i!=0){
                    res.add(i);
                }
                for(int s=0;s<i/2;s++){
                    System.out.println(A[s] + " " + A[i-s]);
                    int temp = A[s];
                    A[s] = A[i-s];
                    A[i-s] = temp;
                }
                for(int ai:A){
                    System.out.print(ai + " ");
                }
                System.out.println();
                for(int s=0;s<=r/2;s++){
                    int temp = A[s];
                    A[s] = A[r-s];
                    A[r-s] = temp;
                }
                res.add(r);
                for(int ai:A){
                    System.out.print(ai + " ");
                }
                System.out.println();
            }
            r--;
            System.out.println("hi ");
        }
        for (int ai:A){
            System.out.print(ai + " is ");
        }
        return res;
    }


    public static boolean sortCheck(int[] A){
        if(A.length < 2){
            return true;
        }
        int i = 0;
        if(A[0] < A[1]){
            i = -1;
        }
        if(i < 0){
            System.out.println("hi1 ");
            for(int j=1;j<A.length;j++){
                if(A[j] - A[j-1] < 0){
                    return false;
                }
            }
            return true;
        }
        if(i == 0){
//            System.out.println("hi2 ");
            for(int j=1;j<A.length;j++){
                if(A[j] - A[j-1] > 0){
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,2,4,1};
        System.out.println(pancakeSort(A));
    }

}