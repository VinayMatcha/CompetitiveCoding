package com.vinay.dfs;

import java.util.ArrayList;
import java.util.Stack;

public class MostStonesRemoved {

    public int removeStones(int[][] stones) {
        ArrayList<Integer>[] graph = new ArrayList[stones.length];
        int length = stones.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int result = 0;
        boolean[] visited = new boolean[stones.length];
        for (int i=0;i<stones.length;i++) {
            if (!visited[i]) {
                result++;
                Stack<Integer> stack = new Stack();
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int parent = stack.pop();
                    for (int child : graph[parent]) {
                        if (!visited[child]) {
                            stack.add(child);
                            visited[child] = true;
                        }
                    }
                }
            }
        }
        return length - result;
    }

}
