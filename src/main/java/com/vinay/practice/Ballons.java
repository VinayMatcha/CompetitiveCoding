package com.vinay.practice;

import java.util.HashMap;
import java.util.Map;

public class Ballons {



    public static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int maxi = 1;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<n;i++) {
            if(map.containsKey(arr[i] - i*difference))
            {
                int freq = map.get(arr[i] - i*difference);
                freq++;
                map.put(arr[i] - i * difference, freq);
            }
            else
            {
                map.put(arr[i] - i * difference, 1);
            }
        }
        for(Map.Entry<Integer, Integer> val: map.entrySet()){
            if (maxi < val.getValue())
                maxi = val.getValue();
        }
        return maxi;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4};
        System.out.println(longestSubsequence(arr, 1));
        int val = 2;
        System.out.println(((val&(val-1)) == 0 ));
    }


//    public int getMaximumGold(int[][] graph) {
//        int ans = 0;
//        boolean[][] visited = new boolean[graph.length][graph[0].length];
//        for (int i = 0; i < grid.length; ++i) {
//            for (int j = 0; j < grid[0].length; ++j) {
//                ans = Math.max(ans, dfs(grid, visited, i, j, 0));
//            }
//        }
//        return ans;
//    }
//
//
//    public int findPath(int[][] graph, boolean[][] visited, int row, int col, int sum) {
//
//        if(row<0 || row>=graph.length || col<0 || col>=graph[0].length || graph[row][col]==0 || visited[row][col])
//            return sum;
//        sum += graph[row][col];
//        visited[row][col] = true; // mark visited.
//        int maxi = 0;
//        for (int k = 0; k < 4; ++k) {
//            maxi = Math.max(maxi, findPath(graph, visited, row+d[k], col+d[k + 1], sum));
//        }
//        visited[row][col] = false; // change back.
//        return maxi;
//    }




}
