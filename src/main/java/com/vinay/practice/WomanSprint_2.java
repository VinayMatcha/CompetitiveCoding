package com.vinay.practice;

import java.util.HashMap;
import java.util.List;

public class WomanSprint_2 {

    public static String productName(List<String> names) {
        // Write your code here
        StringBuilder res = new StringBuilder();
        for(int i=0;i<5;i++){
            HashMap<Integer, Integer> map = new HashMap();
            for(int j=0;j<names.size();j++){
                int p = names.get(j).charAt(i) - 97;
                map.put(p,map.getOrDefault(p, 0)+1);
            }
            int max = 0;
            char check = 'z';
            for(int c=0;c<26;c++){
                int val = 0;
                for(int key:map.keySet()){
                    val += map.get(key) * (Math.abs(key - c));
                }
                if(max < val ){
                    check = (char) (97+c);
                }
            }
            res.append(check);

        }
        return res.toString();
    }


}
