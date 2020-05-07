package com.vinay.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WomanSprint_4 {


    public static int strangelyCompatible(List<String> students) {
        // Write your code here
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> stu = new ArrayList<>();
        for(String st: students) {
            if (!map.containsKey(st)) {
                map.put(st, 1);
                stu.add(st);
            } else {
                map.put(st, map.get(st) + 1);
            }
        }
        for(int i=0;i<stu.size();i++){
            String arr = stu.get(i);
            for(int j=i+1;j<stu.size();j++){
                String arr1 = stu.get(j);
                int diff = 0;
                for(int p=0;p<arr1.length() && diff<2;p++){
                    if(arr.charAt(p) != arr1.charAt(p))
                        diff++;
                }
                if(diff == 1)
                    res += map.get(arr) * map.get(arr1);
            }
        }
        return res;
    }

}
