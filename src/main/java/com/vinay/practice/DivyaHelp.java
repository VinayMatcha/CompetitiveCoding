package com.vinay.practice;

import java.util.ArrayList;
import java.util.List;

public class DivyaHelp {

    public static void main(String[] args) {
        List<Integer> fri = new ArrayList<>();
        fri.add(9);
        fri.add(9);
        fri.add(7);
        fri.add(9);
        fri.add(9);
        fri.add(9);fri.add(9);fri.add(9);fri.add(9);fri.add(9);
        List<String> res = stringAverage(fri);
        for(String set: res)
            System.out.println(set);

    }

    private static List<String> stringAverage(List<Integer> fri) {
        System.out.println("hello");
        List<String> res = new ArrayList<>();
        int i =0;
        float total = 0;
        for(i=0;i<7 && i < fri.size();i++) {
            total += fri.get(i);
        }
        if(i==7) {
            String val = String.format("%.2f", (total/7));
            res.add(val);
        }
        while(i < fri.size()) {
            total += fri.get(i);
            total -= fri.get(i-7);
            String val = String.format("%.2f", (total/7));
            res.add(val);
            i++;
        }
        return res;
    }


}
