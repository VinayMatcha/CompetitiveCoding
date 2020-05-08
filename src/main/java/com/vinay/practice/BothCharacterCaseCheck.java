package com.vinay.practice;

import java.util.HashSet;
import java.util.Iterator;

public class BothCharacterCaseCheck {

    public static void main(String[] args) {
        String st = "azABaabza";
        int min = st.length();
        boolean flag = false;
        for (int i=0;i<st.length();i++) {
            for (int j=i+1;j<=st.length();j++)  {
                String subSt = st.substring(i, j);
                if ( checkCases(subSt)) {
                    System.out.println("hello");
                    flag = true;
                    min = Math.min(min, subSt.length());
                }
            }
        }
        if (flag) {
            System.out.println(min);
        }else {
            System.out.println("-1");
        }

    }

    private static boolean checkCases(String st) {
        HashSet<Character> caps = new HashSet<>();
        HashSet<Character> lows = new HashSet<>();
        for (char ch : st.toCharArray()) {
            if (ch >= 65 && ch <= 90)
                caps.add(ch);
            else
                lows.add(ch);
        }
        System.out.println(caps.size()  + " " + lows.size() + " " + st);
        if (caps.size() != lows.size())
            return false;
        Iterator<Character> capsIt = caps.iterator();
        while (capsIt.hasNext()) {
            char ch = capsIt.next();
            if (!lows.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }

}
