package com.vinay.unionfind;

public class MakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        int extraConnections = 0;
        for (int[] connection : connections) {
            int pid = unionFind.root(connection[0]);
            int qid = unionFind.root(connection[1]);
            if (pid == qid)
                extraConnections++;
            else
                unionFind.union(connection[0], connection[1]);
        }
        int components = unionFind.getComponents();
        return extraConnections >= components-1 ?  components-1 : -1;
    }

}
