package com.vinay.practice;

import java.util.HashMap;
import java.util.List;

public class WomanSprint_3 {
    public static int visuallyBalancedSections(List<Integer> colors) {
        // Write your code here
        int[] color = new int[colors.size()];
        for(int i=0;i<colors.size();i++){
            color[i] = colors.get(i);
        }
        int res = color.length;
        for(int i=0;i<color.length;i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int zeroCount = 0;
            int oneCount = 0;
            int s = map.getOrDefault(color[i], 0);
            if(s%2 == 0){
                oneCount++;
            }else{
                zeroCount++;
            }
            map.put(color[i], s+1);
            for(int j=i+1;j<color.length;j++){
                int q = map.getOrDefault(color[i], 0);
                if(q%2 == 0){
                    oneCount++;
                }else{
                    zeroCount++;
                }
                if(i-j%2 == 1 && oneCount == 1){
                    res++;
                }else if(i-j%2 == 0 && oneCount == 0){
                    res++;
                }
            }
            if(s%2 == 0){
                zeroCount--;
            }else{
                oneCount++;
            }
            map.put(color[i], s-1);
        }
        return res;
    }
}
