package com.vinay.practice;

public class FriednCircles {


    int[] visited;
    public int findCircleNum(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        visited = new int[grid.length];
        int result = 0;
        for(int i=0;i<grid.length;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                findGroup(grid, i);
            }
        }
        return result;
    }

    public void findGroup(int[][] grid, int p){
        int n = grid.length;
        for(int i=0;i<n;i++){
            if(grid[p][i] == 1 && visited[i] == 0){
                findGroup(grid, i);
            }
        }
    }


    public static void main(String[] args) {
        FriednCircles fd = new FriednCircles();
        int[][] grid = new int[][]{{1,0},{0,0}};
        System.out.println(fd.findCircleNum(grid));
    }


}
