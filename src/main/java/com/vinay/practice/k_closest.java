package com.vinay.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k_closest {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ar = new ArrayList<>();
        for(int i : arr){
            ar.add(i);
        }
        Collections.sort(ar, (a, b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        ar = ar.subList(0, k);
        Collections.sort(ar);
        return ar;
    }


    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> ar = new ArrayList<>();
        for(int i : arr){
            ar.add(i);
        }
        int mid = Collections.binarySearch(ar, x);
        if(mid < 0){
            mid = -mid -1;
        }
        int low = Math.max(0, mid - k - 1);
        int high = Math.min(arr.length-1, mid + k - 1);
        int len = arr.length;
        while(low - high > k-1){
            if(low < 0 || (x - arr[low]) <= (arr[high] - x)){
                high--;
            }else if(high > len-1 || (x - arr[low]) > (arr[high] - x)){
                low++;
            }else{

            }
        }
        System.out.println(low + " " + high);
        return ar.subList(low, high+1);
    }

    public int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < x){
                low = mid + 1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }



}
