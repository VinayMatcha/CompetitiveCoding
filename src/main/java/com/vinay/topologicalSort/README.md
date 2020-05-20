# Topological Sort
Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.

Question 1: (TopologicalSort.java)
Given a directed graph, find the topological ordering of its vertices. 

Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

Question 2: (CourseSchedule.java) LeetCode 207

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]

Output: true

Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
             
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible
             
             
Question 3: (CourseScheduleII.java) LeetCode 210
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]

Output: [0,1,2,3] or [0,2,1,3]

Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3]
             
             
        
Question 4: (SequenceReconstruction.java) Leetcode 444

Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. 
The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means
building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input: org = [1,2,3], seqs = [[1,2],[1,3]]

Output: false

Explanation: [1,2,3] is not the only one sequence that can be reconstructed,
 because [1,3,2] is also a valid sequence that can be reconstructed.

Example 2: 
Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]

Output: true 


Question 5: (AlienDictionary.java) Leetcode 269

There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters.
Write a method to find the correct order of characters in the alien language.

Input: Words: ["ba", "bc", "ac", "cab"]

Output: bac

Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:
 
1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 
From the above two points, we can conclude that the correct character order is: "bac"


Question 6: (AllTasksOrdering)
 There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 Given the number of tasks and a list of prerequisite pairs,
 write a method to print all possible ordering of tasks meeting all prerequisites.
 
 Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 
 Output: 
 1) [3, 2, 0, 1]
 2) [3, 2, 1, 0]
 
 Explanation: There are two possible orderings of the tasks meeting all prerequisites.