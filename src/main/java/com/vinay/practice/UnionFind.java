package com.vinay.practice;

class UnionFind{
    public int count = 0;
    public int[] mat;
    public int[] sz;

    public UnionFind(char[][] grid, int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                }
            }
        }
        mat = new int[m*n];
        sz = new int[m*n];
        for(int i=0;i<m*n;i++){
            mat[i] = i;
            sz[i] = 1;
        }
    }

    public UnionFind(int n) {
        count = n;
        mat = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            mat[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p){
        while(p!=mat[p]){
            mat[p] = mat[mat[p]];
            p = mat[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        int pid = find(p);
        int qid = find(q);
        return pid == qid;
    }

    public void union(int p, int q){
        int pid = find(p);
        int qid = find(q);
        if(mat[pid] == mat[qid]){
            return;
        }
        if(sz[pid] < sz[qid]){
            mat[pid] = mat[qid];
            sz[pid] += sz[qid];
        }else {
            mat[qid] = mat[pid];
            sz[qid] += sz[pid];
        }
        count--;
    }

    public void unionLong(int p, int q){
        int pid = find(p);
        int qid = find(q);
        mat[pid] = qid;
    }

    public int findHighestLength(){
        int[] count = new int[mat.length];
        int max = 0;
        for(int i=0;i<mat.length;i++){
//            System.out.println(find(i));
            max = Math.max(max,  ++count[find(i)]);
        }
        return max;
    }


}