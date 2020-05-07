package com.vinay.practice;

public class IslandUnionFind {


    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid, m, n);
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    int p = i * n + j;
                    if(i > 0 && grid[i-1][j] == '1'){
                        int q = p - n;
                        uf.union(p, q);
                    }
                    if(j > 0 && grid[i][j-1] == '1'){
                        int q = p - 1;
                        uf.union(p, q);
                    }

                }
            }
        }
        return uf.count;
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','0'},{'0','0'}};
        System.out.println(numIslands(grid));
    }

}


