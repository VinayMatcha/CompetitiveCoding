package com.vinay.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Barces {

    public static List<List<Integer>> alternatingParityPermutations(int n) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        System.out.println(arr.length + "  " + arr[2]);
        permutating(arr, res, 0, n);
        String[] res1 =  res.toArray(new String[res.size()]);
        Arrays.sort(res1);
        for(String s: res1){
            ArrayList<Integer> ar = new ArrayList();
            for(int i=0;i<s.length();i++){
                ar.add(Character.getNumericValue(s.charAt(i)));
            }
            result.add(ar);
        }
        return result;
    }

    public static void permutating(int[] arr, List<String> res,  int x, int n){
        if(x == n){
            boolean flag = true;
            for(int i=0;i<n-1;i++){
                if((arr[i] + arr[i+1])%2 == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                StringBuilder st = new StringBuilder();
                for(int i=0;i<n;i++){
                    st.append(arr[i]);
                }
                res.add(st.toString());
            }
        }else{
            for(int i=x;i<n;i++){
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
                permutating(arr, res, x+1, n);
                temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> result = new ArrayList<>();
        result = alternatingParityPermutations(n);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

}
