package com.vinay.practice;

public class MergeSort {


    public static void merge(Comparable[] arr, Comparable[] aux,int low, int mid, int high){
        for(int i=low;i<=high;i++){
            aux[i] = arr[i];
        }
        int i = low;
        int j = mid+1;
        int k =low;
        while (i <= mid && j<=high){
            if(less(aux[i], aux[j])){
                arr[k++] = aux[i++];
            }else{
                arr[k++] = aux[j++];
            }
        }

        while(i <= mid){
            arr[k++] = aux[i++];
        }
        while(j <= high){
            arr[k++] = aux[j++];
        }
    }


    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }


    public static void sort(Comparable[] arr, Comparable[] aux, int low, int high){
        if(high <= low){
            return;
        }
        int mid = low + (high - low)/2;
        sort(arr, aux, low, mid);
        sort(arr,aux, mid+1, high);
        merge(arr,aux, low, mid, high);
    }

    public static void sort(Comparable[] a){
        Comparable[] ta = new Comparable[a.length];
        sort(a, ta, 0, a.length-1);
    }

    public static void main(String[] args) {
        String[] st = "a c d r b e n r".split(" ");
        sort(st);
        for (String str:st)
        System.out.println(str);
    }

}
