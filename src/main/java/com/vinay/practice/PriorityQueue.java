package com.vinay.practice;

public class PriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public PriorityQueue(int capacity){
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public  void insert(Key key){
        pq[++N] = key;
        swim(N);
    }


    public void swap(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean less(int a, int b){
        return pq[a].compareTo(pq[b]) < 0;
    }

    public void sink(int i){
        int k = i;
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)){
                j++;
            }
            if(!less(k, j)){
                break;
            }
            swap(k, j);
            k = 2*k;
        }
    }


    public void swim(int i){
        int k = i;
        while(k > 1 && less(k/2, k)){
            swap(k, k/2);
            k = k/2;
        }
    }

    public Key deleteMax(){
        Key max = pq[1];
        swap(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    public void print(){
        for(int i=0;i<=N;i++){
            System.out.print(" " + pq[i]);
        }
        System.out.println(" completed");
    }

    public static void main(String[] args) {
        String[] st = "r s o j n g q i p h".split(" ");
        PriorityQueue pqr = new PriorityQueue(st.length);
        for(int i=0;i<st.length;i++){
            if(i != 0 && i%3 == 0){
                System.out.println(pqr.deleteMax());
                pqr.print();
            }
            pqr.insert(st[i]);
            pqr.print();
        }
        pqr.deleteMax();
        pqr.print();
        for (String str:st)
            System.out.println(str);
    }



}
