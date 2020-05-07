package com.vinay.practice;

import java.util.ArrayList;

public class PrimeNyumbersPrashanth {


    public static void main(String[] args) {
        boolean flag = false;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(2);
        for(int i=3;i<100;i++){
            flag = false;
            for(int j=2;j<=Math.sqrt(i) && (!flag);j++){
                if(i%j==0 && (result.contains(i/j)|| result.contains(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(i);
            }
        }
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
