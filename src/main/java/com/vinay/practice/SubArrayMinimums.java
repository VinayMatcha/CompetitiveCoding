package com.vinay.practice;

import java.util.Stack;

public class SubArrayMinimums {
    public static int sumSubarrayMins(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && A[stack.peek()]>A[i]){
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        long res = 0;
        for(int i=0;i<n;i++){
            res += ((i - prev[i]) * (next[i] - i) % mod) * A[i] % mod;
            res = res%mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
