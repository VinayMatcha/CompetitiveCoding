package com.vinay.practice;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {

    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder res = new StringBuilder();
        for(String st: str){
            System.out.println(st);
            res.append(st);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] A = new int[]{9, 90, 5};
        System.out.println("5".compareTo("10"));
        System.out.println(largestNumber(A));
    }

}
