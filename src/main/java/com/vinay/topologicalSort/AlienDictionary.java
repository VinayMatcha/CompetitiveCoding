package com.vinay.topologicalSort;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.findOrder(new String[] { "wrt","wrf","er","ett","rftt" });
        System.out.println("Character order: " + result);
    }

    private  String findOrder(String[] words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length <= 0)
            return result.toString();

        //Intializaing the graph
        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, List<Character>> adjacencyList = new HashMap<>();

        //building the adjacency list
        for (String word : words) {
            for (Character ch: word.toCharArray()) {
                if (!indegree.containsKey(ch)) {
                    indegree.put(ch, 0);
                    adjacencyList.put(ch, new ArrayList<>());
                }
            }
        }
        
        for (int i=0;i<words.length-1;i++) {
            String word = words[i];
            String word1 = words[i+1];
            for (int j=0;j<Math.min(word.length(), word1.length());j++) {
                char word1Char = word.charAt(j);
                char word2char = word1.charAt(j);
                if ( word1Char != word2char) {
                    indegree.put(word2char, indegree.get(word2char)+1);
                    adjacencyList.get(word1Char).add(word2char);
                    break;
                }
            }
        }

        // Find all sources with indegree 0 which will act as start point
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        while (!sources.isEmpty()) {
            char presentCharacter = sources.poll();
            System.out.println(presentCharacter);
            List<Character> children = adjacencyList.get(presentCharacter);
            for (char child : children) {
                int childIndegree = indegree.get(child);
                indegree.put(child, childIndegree-1);
                if (childIndegree == 1)
                    sources.add(child);
            }
            result.append(presentCharacter);
        }
        if (result.length() != indegree.size())
            return "";
        return result.toString();
    }


}
