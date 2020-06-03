package com.vinay.priorityQueue;

public class UnorderedPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public UnorderedPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (isless(max, i))
                max = i;
        }
        swap(max, N-1);
        return pq[--N];
    }

    private boolean isless(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap (int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}
