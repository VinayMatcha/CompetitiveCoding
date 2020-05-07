package com.vinay.practice;

public class LeetCode126_2 {

    public static boolean isValid(String S) {
        boolean flag = true;
        int chars[] = new int[3];
        String p = S;
        for(int i =0;i<S.length()/3;i++){
            if(p.length() > 0){
                p = p.replaceAll("abc", "");
            }
        }
        return p.length()==0;
    }

    public static void main(String[] args) {
        String p = "aabcbc";
        isValid(p);
    }

}
