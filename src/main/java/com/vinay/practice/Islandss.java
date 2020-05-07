package com.vinay.practice;

public class Islandss {

    static int  numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int sum = sink(i,j+1,grid) + sink(i,j-1,grid) + sink(i+1,j, grid) + sink(i-1,j,grid);
                if(sum == 0){
                    count++;
                }
            }
        }
        return count;
    }

    static int sink(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length){
            return 0;
        }else if(grid[i][j] == 1){
            return 1;
        }
        return 0;
    }

}

