package com.vinay.practice;

import java.util.HashSet;

public class ReplacePalindrome {
    public static void main(String[] args) {
        String s= "?ab??a";
        int i=0;
        HashSet<Character> set = new HashSet<>();
        Character rep = null;
        for(i=0;i<s.length()/2;i++){
            if(s.charAt(i)=='?' && s.charAt(s.length()-i-1)!='?'){

                set.add(s.charAt(s.length()-i-1));
                if (rep == null) {
                    rep = s.charAt(s.length()-i-1);
                }
            }else if(s.charAt(i)!='?' && s.charAt(s.length()-i-1)=='?'){
                set.add(s.charAt(i));
                if (rep == null) {
                    rep = s.charAt(i);
                }
            }
            else if(s.charAt(i)!= s.charAt(s.length()-i-1)){
                    System.out.println("NO");
//                return "NO";
            }
        }
        System.out.println(set.size());
         if (set.size() > 1) {
//             return "NO";
             System.out.println("NO");
         } else {
             if(rep == null) {
                 rep = 'a';
             }
             String result = s.replace('?', rep);
             System.out.println(result);
         }

    }
}
