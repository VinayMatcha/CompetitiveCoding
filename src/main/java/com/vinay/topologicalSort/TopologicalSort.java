package com.vinay.topologicalSort;


import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> result = null;
        try {
            result = topologicalSort.sort(4,
                    new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            result = topologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                    new int[] { 2, 1 }, new int[] { 3, 1 } });
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            result = topologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                    new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<Integer> sort(int verticesCount, int[][] edges) throws Exception {
        List<Integer> sortedResult = new ArrayList<>();
        if (verticesCount <= 0)
            return sortedResult;

        //Intializaing the graph
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i=0;i<verticesCount;i++) {
            indegree.put(i, 0);
            adjacencyList.put(i, new ArrayList<>());
        }

        //building the adjacency list
        for (int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            indegree.put(edge[1], indegree.get(edge[1])+1);
        }

        // Find all sources with indegree 0 which will act as start point
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        while (!sources.isEmpty()) {
            int presetnVertex = sources.poll();
            List<Integer> children = adjacencyList.get(presetnVertex);
            for (int child : children) {
                int childIndegree = indegree.get(child);
                indegree.put(child, childIndegree-1);
                if (childIndegree == 1)
                    sources.add(child);
            }
            sortedResult.add(presetnVertex);
        }
        if (sortedResult.size() != verticesCount)
            throw new Exception(" Topological sort not possible");
        return sortedResult;
    }
}
