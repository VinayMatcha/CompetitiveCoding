package com.vinay.practice;

import java.util.Scanner;
import java.util.TreeMap;

public class MatrixDiagobal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int m = Integer.parseInt(sc.nextLine().trim());
        char arr[][] = new char[n][m];
        int maxString = Math.min(n, m);
        for(int i=0;i<n;i++) {
            String st = sc.nextLine();
            for(int j=0;j<m;j++) {
                arr[i][j] = st.charAt(j);
            }
        }
//        System.out.println("Matrix printing ");
        //4 5 1 2 3 4 5 5 6 7 8 6 9 10 11 12 7 13 14 15 16 8
        /*
6
5
abcde
defgh
ijklm
abcde
defgh
abcde
         */
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Diagonal Matrix printing ");
        TreeMap<String, Integer> stringMap = new TreeMap<>();
        int colStart = 0;
        int position = n;
        while(colStart < m ) {
            int rowStart = 0;
            int colTemp = colStart;
            StringBuilder st = new StringBuilder();
            int count = 0;
            while(colTemp < m && rowStart <  n) {
                System.out.print(arr[rowStart][colTemp] + " ");
                st.append(arr[rowStart][colTemp]);
                colTemp++;
                rowStart++;
                count++;
            }
            int start = 0;
            while(st.length() < maxString) {
                st.append(st.charAt(start % count));
                start++;
            }
            stringMap.put(st.toString(), position++);
            System.out.print("-> " + st.toString() + " " + stringMap.get(st.toString()));
            System.out.println();
            colStart++;
        }
        int rowStart = 1;
        position = n-1;
        while(rowStart < n) {
            colStart = 0;
            int rowTemp = rowStart;
            StringBuilder st = new StringBuilder();
            int count = 0;
            while (rowTemp < n && colStart < m) {
//                System.out.print(arr[rowTemp][colStart] + " ");
                st.append(arr[rowTemp][colStart]);
                rowTemp++;
                colStart++;
                count++;
            }
            int start = 0;
            while(st.length() < maxString) {
                st.append(st.charAt(start%count));
                start++;
            }
            stringMap.put(st.toString(), position--);
//            System.out.print(st.toString() + " " + stringMap.get(st.toString()));
            rowStart++;
//            System.out.println();
        }

        System.out.println(" answer is ");
        for(String key : stringMap.keySet()) {
            System.out.println(key + " " + stringMap.get(key));
        }

    }

}
