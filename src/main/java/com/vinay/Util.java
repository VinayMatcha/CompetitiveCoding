package com.vinay;

import java.util.List;

public class Util {
    public static int[] listToIntArray(List<Integer> arr) {
        int[] result = new int[arr.size()];
        for (int i=0; i<arr.size();i++)
            result[i] = arr.get(i);
        return result;
    }

    public static void printArrayWithMessage(int[] arr, String message) {
        System.out.println(message);
        for (int a: arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
