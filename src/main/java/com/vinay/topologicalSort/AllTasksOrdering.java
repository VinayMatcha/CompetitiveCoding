package com.vinay.topologicalSort;

import java.util.*;

public class AllTasksOrdering {
    public static void main(String[] args) {
        AllTasksOrdering allTasksOrdering = new AllTasksOrdering();
        int tasksDependencies[][] =  new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } };
        allTasksOrdering.printOrder(3, tasksDependencies);
        allTasksOrdering.printOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    }

    public void printOrder(int tasks, int[][] tasksDependencies) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
            return;

        //Intializaing the graph
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i=0;i<tasks;i++) {
            indegree.put(i, 0);
            adjacencyList.put(i, new ArrayList<>());
        }

        //building the adjacency list
        for (int[] edge: tasksDependencies) {
            adjacencyList.get(edge[0]).add(edge[1]);
            indegree.put(edge[1], indegree.get(edge[1])+1);
        }

        // Find all sources with indegree 0 which will act as start point
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        printAllTopologicalOrders(adjacencyList, indegree, sources, sortedOrder);
    }

    private void printAllTopologicalOrders(HashMap<Integer, List<Integer>> adjacencyList, HashMap<Integer, Integer> indegree, Queue<Integer> sources, List<Integer> sortedOrder) {

        if (!sources.isEmpty()) {
            for (Integer vertex: sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                sourcesForNextCall.remove(vertex);
                List<Integer> children = adjacencyList.get(vertex);
                for (int child : children) {
                    int value = indegree.get(child);
                    indegree.put(child, value-1);
                    if (value == 1)
                        sourcesForNextCall.add(child);
                }
                printAllTopologicalOrders(adjacencyList, indegree, sourcesForNextCall, sortedOrder);
                sortedOrder.remove(vertex);
                for (int child : children) {
                    indegree.put(child, indegree.get(child)+1);
                }
            }
        }

        if (sortedOrder.size() == indegree.size())
            System.out.println(sortedOrder);
    }

    public Queue<Integer> cloneQueue(Queue<Integer> sources) {
        Queue<Integer> resultQueue = new LinkedList<>();
        for (int val : sources)
            resultQueue.add(val);
        return resultQueue;
    }
}
