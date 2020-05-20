package com.vinay.topologicalSort;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = new int[][] {new int[] { 1, 0 }};
        if (courseSchedule.canFinish(numCourses, prerequisites)) {
            System.out.println(" Can finsih courses");
        } else {
            System.out.println(" Cannot finish courses");
        }

    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return true;
        int completedCourses = 0;
        //Intializaing the graph
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i=0;i<numCourses;i++) {
            indegree.put(i, 0);
            adjacencyList.put(i, new ArrayList<>());
        }

        //building the adjacency list
        for (int[] prerequisite: prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            indegree.put(prerequisite[0], indegree.get(prerequisite[0])+1);
        }

        // Find all sources with indegree 0 which will act as start point
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            int presetnVertex = sources.poll();
            System.out.println(presetnVertex);
            List<Integer> children = adjacencyList.get(presetnVertex);
            for (int child : children) {
                int childIndegree = indegree.get(child);
                indegree.put(child, childIndegree-1);
                if (childIndegree == 1)
                    sources.add(child);
            }
            completedCourses++;
        }
        if (completedCourses != numCourses)
            return false;
        return true;
    }

}
