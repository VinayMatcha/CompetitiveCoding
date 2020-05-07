package com.vinay.practice;

public class InsertionSort {

    public void sort(Comparable[] a){
        int n = a.length;
        for(int i=0;i<n;i++) {
            for(int j=i;j>0;j--){
                if(less(a[j], a[j-1])){
                    swap(a, j , j-1);
                }else {
                    break;
                }
            }
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
        InsertionSort sort = new InsertionSort();
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
