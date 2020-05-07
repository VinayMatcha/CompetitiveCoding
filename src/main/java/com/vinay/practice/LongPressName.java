package com.vinay.practice;

import java.util.Stack;

public class LongPressName {


    public static boolean isLongPressedName(String name, String typed) {
        Stack<Character> st = new Stack<>();
        int n = name.length();
        int p = typed.length();
        int i =0 ;
        int j =0;
        while (i < n && j < p){
            st.push(name.charAt(i++));
            if(j < p && st.peek() == typed.charAt(j)){
                j++;
            }
            st.pop();
        }
        if(st.isEmpty() && i == n && j == p){
            return true;
        }else{
            return false;
        }
    }

}
