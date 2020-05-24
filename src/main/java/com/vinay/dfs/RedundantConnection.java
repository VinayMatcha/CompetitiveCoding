package com.vinay.dfs;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[1001];

        for (int i=0;i<1001;i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge: edges) {
            if (hasPath(graph, edge[0], edge[1]))
                return edge;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }

    private boolean hasPath(ArrayList<Integer>[] graph, int start, int end) {
        Set<Integer> visited = new HashSet();
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            int parent = stack.pop();
            if (visited.contains(parent))
                continue;
            if (parent == end)
                return true;
            for (int child : graph[parent])
                stack.add(child);
            visited.add(parent);
        }
        return false;
    }


}
