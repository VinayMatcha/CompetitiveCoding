package com.vinay.unionfind;

public class FriendsCircle {

    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j=0;j<M[i].length;j++) {
                if (M[i][j] == 1)
                    unionFind.union(i, j);
            }
        }
        return unionFind.getComponents();
    }

}
