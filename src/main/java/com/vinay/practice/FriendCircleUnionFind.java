package com.vinay.practice;

public class FriendCircleUnionFind {


    public int findCircleNum(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int n = grid.length;
        UnionFind uf = new UnionFind(n);
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if (grid[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        FriendCircleUnionFind fd = new FriendCircleUnionFind();
        int[][] grid = new int[][]{{1,0},{0,0}};
        System.out.println(fd.findCircleNum(grid));
    }


}
