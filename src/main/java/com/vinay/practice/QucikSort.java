package com.vinay.practice;

public class QucikSort {


    public static void sort(Comparable[] a, int low, int high){
        if(high <= low){
            return;
        }
        int mid = partition(a, low, high);
        sort(a, low, mid-1);
        sort(a, mid+1, high);
    }


    public static int partition(Comparable[] a, int low, int high){
        int i = low;
        int j = high;
        while(true){
            while(i < high){
                if(less(a[i], a[high])){
                    break;
                }
                i++;
            }
            while(j > low){
                if(less(a[j], a[low])){
                    break;
                }
                j--;
            }
            if(i >= j){
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }


    public static void swap(Comparable[] a, int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }


    public static void main(String[] args) {
        String[] st = "a c d r b e n r p".split(" ");
        sort(st, 0, st.length-1);
        for (String str:st)
            System.out.println(str);
    }


}
