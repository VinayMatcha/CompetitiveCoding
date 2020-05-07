package com.vinay.practice;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(map.containsKey(n)){
                continue;
            }
            map.put(n, i);
            if(map.containsKey(n+1)){
                uf.union(i, map.get(n+1));
            }
            if(map.containsKey(n-1)){
                uf.union(i, map.get(n-1));
            }
        }
        return uf.findHighestLength();
    }


    public static void main(String[] args) {
        int[] a = new int[]{100,99,1,6,3,5,2};
        System.out.println(longestConsecutive(a));
    }


}
