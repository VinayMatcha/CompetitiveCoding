package com.vinay.practice;

public class MergeSortBottomUp {


    public static Comparable aux[];
    public static void merge(Comparable[] arr,int low, int mid, int high){
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

    public static void sort(Comparable[] a){
        int N  = a.length;
        aux = new Comparable[N];
        for(int i=1;i<N;i=i*2){
            for(int j=0;j<N-i;j+=i*2){
                merge(a, j, j+i-1, Math.min(j+i+i, N-1));
            }
        }
    }

    public static void main(String[] args) {
        String[] st = "a c d r b e n r p".split(" ");
        sort(st);
        for (String str:st)
            System.out.println(str);
    }


}
