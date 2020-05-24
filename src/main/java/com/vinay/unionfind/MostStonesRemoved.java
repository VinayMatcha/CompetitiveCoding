package com.vinay.unionfind;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
         UnionFind unionFind = new UnionFind(20000);
         for (int[] stone: stones) {
             unionFind.union(stone[0], stone[1] + 10000);
         }
         Set<Integer> visited = new HashSet<>();
         for (int[] stone: stones)
             visited.add(unionFind.root(stone[0]));
         return stones.length - visited.size();
    }
}
