package com.vinay.priorityQueue;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && isless(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k < N) {
            int child = 2*k;
            if (child < N && isless(child, child+1))
                child++;
            swap(child, k);
            k = child;
        }
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
