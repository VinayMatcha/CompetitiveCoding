package com.vinay.practice;

import java.util.HashMap;

public class Visa1 {

    public static char maximumOccurance(String text){
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] chars = new char[26];
        for(int i=0;i<text.length();i++){
            char a = text.charAt(i);
            if(chars[a-97] == 0){
                map.put(a-97,i);
            }
            chars[a-97]++;
        }
        int max = 0;
        int charPos = -1;
        int charValue = 0;
        for (int i=0;i<26;i++){
            int p = chars[i];
            if(p > max){
                max = p;
                charPos = map.get(i);
                charValue = i;
            }else if(p == max && charPos > map.get(i)){
                charPos = map.get(i);
                charValue = i;
            }
        }
        return (char) (charValue + 97);
    }

    public static void main(String[] args) {
        System.out.println(maximumOccurance("abbbaac"));
    }


}
