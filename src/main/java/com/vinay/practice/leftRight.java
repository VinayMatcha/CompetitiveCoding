package com.vinay.practice;

import java.util.ArrayList;
import java.util.List;

public class leftRight {


    public static List<String> combsi = new ArrayList<>();

    public static void combinations(String suffix,String prefix){
        if(prefix.length()<0)
            return;
        combsi.add(suffix);
        for(int i=0;i<prefix.length();i++)
            combinations(suffix+prefix.charAt(i),prefix.substring(i+1,prefix.length()));
    }

    public static void main (String args[]){
        combinations("","rrlrlr");
        int count = 0;
        int start = 1;
        int end = 4;
        int d = end - start;
        List<String> res = new ArrayList<>();
        for(int i =0;i<combsi.size();i++){
            String check = combsi.get(i);
            if(check.length() >= d && checking(check, d) && !res.contains(check)){
                count++;
                res.add(check);
            }
        }
        System.out.println(count);
    }

    public static boolean checking(String check, int d){
        int diff = 0;
        for(int i=0;i<check.length();i++){
            if(check.charAt(i) == 'r'){
                diff++;
            }else{
                diff--;
            }
        }
        return (diff == d);
    }
}