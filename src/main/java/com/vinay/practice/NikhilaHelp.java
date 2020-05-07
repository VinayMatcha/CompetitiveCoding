package com.vinay.practice;

import java.util.List;
import java.util.TreeMap;

public class NikhilaHelp {

    public static int segment(int x, List<Integer> arr) {
        // Write your code here
        // int min=10000000;
//        int maxi = Integer.MIN_VALUE
//
// jinjij;
//        int min = arr.get(0);
//        int secondMin = arr.get(0);
//        for(int j=0;j<x;j++){
//            int present = arr.get(j);
//            if(present <= min) {
//                secondMin = min;
//                min = present;
//            }
//        }
//        maxi = Math.max(maxi, min);
//        for(int i=x;i<arr.size()-x;i++){
//            int val = arr.get(i-x);
//            if(val == )
//        }
//        return maxi;
//        int len = arr.size();
//        final int[] max_left = new int[len];
//        final int[] max_right = new int[len];
//
//        max_left[0] = arr.get(0);
//        max_right[len - 1] = arr.get(len - 1);
//        for (int i = 1; i < len; i++) {
//            max_left[i] = (i % x == 0) ? arr.get(i) : Math.max(max_left[i - 1], arr.get(i));
//
//            final int j = len - i - 1;
//            max_right[j] = (j % x == 0) ? arr.get(j) : Math.max(max_right[j + 1], arr.get(j));
//        }
//
//        final int[] sliding_max = new int[len - x + 1];
//        for (int i = 0, j = 0; i + x <= len; i++) {
//            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
//        }
//
//        return sliding_max;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int j=0;j<x;j++){
            int present = arr.get(j);
            map.put(present, map.getOrDefault(present, 0)+1);
        }
        int max = map.firstKey();
        for(int i=x;i<arr.size();i++) {
            int present = arr.get(i);
            int last = arr.get(i-x);
            if(map.get(last) == 1) {
                map.remove(last);
            } else {
                map.put(last, map.get(last)-1);
            }
            map.put(present, map.getOrDefault(present, 0)+1);
            max = Math.max(max, map.firstKey());
        }
        return max;


    }

    public static void main(String[] args) {

    }


}
