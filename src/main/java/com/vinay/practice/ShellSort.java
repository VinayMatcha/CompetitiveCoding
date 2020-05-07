package com.vinay.practice;

public class ShellSort {

    public void sort(Comparable[] a){
        int n = a.length;
        int h = 1;
        while(h < n/3){
            h = h*3 +1;
        }
        while(h >= 1){
            for(int i=h;i<n;i++){
                for(int j=i;j>=h;j=j-h){
                    if(less(a[j], a[j-h])){
                        swap(a, j, j-h);
                    }
                }
            }
            h = h/3;
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
        ShellSort sort = new ShellSort();
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
