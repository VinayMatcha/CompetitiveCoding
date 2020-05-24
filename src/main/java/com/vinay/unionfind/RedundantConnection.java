package com.vinay.unionfind;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(1001);
        for (int[] edge: edges) {
            int pid = unionFind.root(edge[0]);
            int qid = unionFind.root(edge[1]);
            if (pid == qid)
                return edge;
            unionFind.union(pid, qid);
        }
        throw new AssertionError();
    }

}
