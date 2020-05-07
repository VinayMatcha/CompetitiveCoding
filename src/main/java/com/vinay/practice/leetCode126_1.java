package com.vinay.practice;

import java.util.ArrayList;
import java.util.List;

public class leetCode126_1 {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] chars = new int[26];
        boolean flag = true;
        for(String s : A){
            int[] check = new int[26];
            for(int i =0;i<s.length();i++){
                if(flag) {
                    chars[s.charAt(i) - 97]++;
                }else{
                    check[s.charAt(i)-97]++;
                }
            }
            for(int i=0;i<26;i++){
                chars[i] = Math.min(chars[i], check[i]);
            }
        }
        for(int i=0;i<26;i++){
            while (chars[i]-- > 0){
                char s = (char) (97 + i);
                res.add(String.valueOf(s));


            }
        }
        return res;
    }

}
