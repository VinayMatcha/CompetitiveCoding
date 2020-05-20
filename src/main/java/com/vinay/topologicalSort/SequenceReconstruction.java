package com.vinay.topologicalSort;

import java.util.*;

public class SequenceReconstruction {

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] org = new int[] {4,1,5,2,6,3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(5, 2, 6, 3));
        seqs.add(Arrays.asList(4,1,5,2));
        if (sequenceReconstruction.sequenceReconstruction(org, seqs)) {
            System.out.println(" Can be formed");
        } else {
            System.out.println(" cannot be formed");
        }
//        seqs.clear();
//        seqs.add(new ArrayList<>(new int[]{5,2,6,3}));
//        seqs.add(new ArrayList<>(new int[]{4,1,5,2}));
//        if (sequenceReconstruction.sequenceReconstruction(org, seqs)) {
//            System.out.println(" Can be formed");
//        } else {
//            System.out.println(" cannot be formed");
//        }
    }


    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0 && org.length == 0)
            return true;
        if(seqs.size() == 0 || org.length == 0)
            return false;

        int completedCourses = 0;
        //Intializaing the graph
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        //building the adjacency list
        for (List<Integer> seq: seqs) {
            if (seq.size() == 1 && !adjacencyList.containsKey(seq.get(0))) {
                indegree.put(seq.get(0), indegree.getOrDefault(seq.get(0), 0));
                adjacencyList.put(seq.get(0), new ArrayList<>());
            }

            for (int i=1;i<seq.size();i++) {
                int parent = seq.get(i-1);
                int child  = seq.get(i);
                if (!adjacencyList.containsKey(parent))
                    adjacencyList.put(parent, new ArrayList<>());
                if (!adjacencyList.containsKey(child))
                    adjacencyList.put(child, new ArrayList<>());
                indegree.put(parent, indegree.getOrDefault(parent, 0));

//                indegree.put(seq.get(0), indegree.getOrDefault(seq.get(0), 0));
                adjacencyList.get(parent).add(child);
                indegree.put(child, indegree.getOrDefault(child, 0)+1);
            }
        }

        // Find all sources with indegree 0 which will act as start point
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        if (sources.size() == 0)
            return false;
        int index = 0;
        while (!sources.isEmpty()) {
            if (sources.size() > 1)
                return false;
            int presetnVertex = sources.poll();
            if (index == org.length || presetnVertex != org[index])
                return false;
            List<Integer> children = adjacencyList.get(presetnVertex);
            for (int child : children) {
                int childIndegree = indegree.get(child);
                indegree.put(child, childIndegree-1);
                if (childIndegree == 1)
                    sources.add(child);
            }
            index++;
        }
        return index == org.length && index == adjacencyList.size();
    }

}
