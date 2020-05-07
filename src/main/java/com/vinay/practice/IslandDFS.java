package com.vinay.practice;

public class IslandDFS {

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    findIsland(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void findIsland(char[][] grid, int i, int j){
        int dx[] = {-1, 0, 0, 1};
        int dy[] = {0, 1, -1, 0};
        grid[i][j] = '2';
        for(int p=0;p<dx.length;p++){
            int di = i + dy[p];
            int dj = j+ dx[p];
            if(di<grid.length && di>=0 && dj<grid[0].length && dj>=0 && grid[di][dj] == '1'){
                findIsland(grid, di, dj);
            }
        }
    }

}
