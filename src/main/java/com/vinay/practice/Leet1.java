package com.vinay.practice;

import java.util.ArrayList;
import java.util.List;

public class Leet1 {

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xi = new ArrayList<Integer>();
        List<Integer> yi = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int r = 1;
        xi.add(1);
        yi.add(1);
        if(x!=0 && x!=1){
            System.out.println("hi");
            while(r < bound){
                r *= x;
                xi.add(r);
            }
        }
        r = 1;
        if(y!=0 && y!=1){
            System.out.println(r);
            while(r < bound){
                r *= y;
                yi.add(r);
            }
        }
        for(int i=0;i<xi.size();i++){
            for(int j=0;j<yi.size();j++){
                r = xi.get(i) + yi.get(j);
                if(r > bound){
                    break;
                }
                if(!res.contains(r)){
                    res.add(r);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(1,2,10));
    }


}
