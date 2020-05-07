package com.vinay.practice;

public class SelectionSort {

    public void sort(Comparable[] a){
        int n = a.length;
        for(int i=0;i<n;i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] a, int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        String[] st = "to be or not is a question".split(" ");
//        int[] a = new int[]{2,5,6,1,4,3};
        SelectionSort sort = new SelectionSort();
        for(String str: st){
            System.out.print(str + " ");
        }
        System.out.println();
        sort.sort(st);
//        sort.sort(a);
        for(String str: st){
            System.out.print(str + " ");
        }
        System.out.println();
    }

}
