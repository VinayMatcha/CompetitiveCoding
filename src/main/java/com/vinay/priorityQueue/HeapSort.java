package com.vinay.priorityQueue;

public class HeapSort {

    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k=N/2; k>=1; k--) {
            sink(pq, k, N);
        }
        while (N > 1) {
            swap(pq, 1, N);
            sink(pq, 1, --N );
        }
    }

    private static void sink(Comparable[] pq, int k, int N) {
        while (2*k < N) {
            int child = 2*k;
            if (child < N && isless(pq, child, child+1))
                child++;
            swap(pq, child, k);
            k = child;
        }
    }

    private static boolean isless(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void swap (Comparable[] pq, int i, int j) {
        Comparable temp = pq[i - 1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

}
