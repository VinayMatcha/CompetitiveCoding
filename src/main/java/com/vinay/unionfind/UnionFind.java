package com.vinay.unionfind;

public class UnionFind {

    private int[] id;
    private int[] size;

    public UnionFind(int N) {
        id = new int[N];
        size = new int[N];
        for (int i=0;i<N;i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (pid != qid) {
            if (size[pid] < size[qid]) {
                id[pid] = qid;
                size[qid] += size[pid];
            } else {
                id[qid] = pid;
                size[pid] += size[qid];
            }
        }
    }

    public int getComponents() {
        int count = 0;
        for (int i=0;i<id.length;i++) {
            if (id[i] == i)
                count++;
        }
        return count;
    }

}
