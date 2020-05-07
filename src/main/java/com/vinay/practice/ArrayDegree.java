package com.vinay.practice;//import java.util.HashMap;
//import java.util.Scanner;
//
//public class ArrayDegree {
//
//    public int findShortestSubArray(int[] nums) {
//        HashMap<Integer, Integer> res = new HashMap();
//        int max = 0;
//        int resNum = 0;
//        int end = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (res.containsKey(nums[i])) {
//                int j = res.get(nums[i]) + 1;
//                if (j > max) {
//                    max = j;
//                }
//                res.put(i, j);
//            } else {
//                res.put(i, 1);
//            }
//        }
//        int result = 0;
//        for (int i : res.keySet()) {
//            if (res.get(i) == max) {
//                int r = calDistance(nums, i);
//                if (r < result) {
//                    result = r;
//                }
//            }
//        }
//        return result;
//    }
//
//    private int calDistance(int[] nums, int x) {
//        int start =0;
//        int end =0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] == x){
//                start = i;
//                break;
//            }
//        }
//        for(int i=nums.length-1;i>0;i--){
//            if(nums[i] == x){
//                end = i;
//                break;
//            }
//        }
////        return end-start+1;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a =
//    }
//
//}
