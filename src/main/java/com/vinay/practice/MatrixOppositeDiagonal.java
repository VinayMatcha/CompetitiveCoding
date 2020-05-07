package com.vinay.practice;//package Nikhila;
//
//import java.util.*;
//
//public class MatrixOppositeDiagonal {
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int arr[][] = new int[n][m];
//        TreeMap<Integer, Integer> intMap = new TreeMap<>();
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                arr[i][j] = sc.nextInt();
//                intMap.put(arr[i][j], intMap.getOrDefault(arr[i][j], 0)+1);
//            }
//        }
//
//                System.out.println("Matrix printing ");
//        //4 5 1 2 3 4 5 5 6 7 1 0 1 2 3 -1 -1 -2 -4 -9 1 2
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Diagonal Matrix printing ");
//        int[] arrAcces = new int[m*n];
//        int pos = m*n;
//        for(int key : intMap.keySet() ) {
//            int count = intMap.get(key);
//            while(count-- > 0) {
//                arrAcces[--pos] = key;
//                System.out.print(key + " ");
//            }
//        }
//        int colStart = 0;
//        while(colStart < m ) {
//            int rowStart = 0;
//            int colTemp = colStart;
//            while(colTemp >= 0  && rowStart < n) {
//                arr[rowStart][colTemp]  = arrAcces[pos++];
//                colTemp--;
//                rowStart++;
//            }
//            colStart++;
//        }
//        int rowStart = 1;
//        while(rowStart < n) {
//            colStart = m-1;
//            int rowTemp = rowStart;
//            while (rowTemp < n && colStart >= 0) {
//                arr[rowTemp][colStart] = arrAcces[pos++];
//                rowTemp++;
//                colStart--;
//            }
//            rowStart++;
//        }
//        System.out.println("final answer is ");
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        ArrayList<Integer> arr= new ArrayList<>();
//        Collections.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//    }
//
//
//}
