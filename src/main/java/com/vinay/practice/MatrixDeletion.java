package com.vinay.practice;

import java.util.Scanner;
import java.util.TreeSet;

public class MatrixDeletion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> rowSet = new TreeSet<>();
        TreeSet<Integer> colSet = new TreeSet<>();
        int start = 0;
        while(start++ < n) {
            rowSet.add(start);
        }
        start = 0;
        while(start++ < m) {
            colSet.add(start);
        }
//        System.out.println(rowSet.size() + " " + colSet.size());
        System.out.println("minimum is ");
        System.out.println((rowSet.first()) * (colSet.first()) );
        rowSet.remove(2);
        System.out.println("deleted 2");
        System.out.println((rowSet.first()) * (colSet.first()) );
        rowSet.remove(1);
        System.out.println("deleted 1");
        System.out.println((rowSet.first()) * (colSet.first()) );


    }


}
