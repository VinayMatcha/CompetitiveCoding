package com.vinay.practice;

import java.util.TreeMap;

public class OddEvenJump {

    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if(n <= 1) {
            return n;
        }
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = even[n-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        for(int i = n-2;i>=0;i--){
            int v = A[i];
            if(map.containsKey(v)){
                even[i] = even[map.get(v)];
                odd[i] = odd[map.get(v)];
            }else{
                Integer low = map.lowerKey(v);
                Integer high = map.higherKey(v);
                if(low!=null){
                    even[i] = odd[map.get(low)];
                }
                if(high != null){
                    odd[i] = even[map.get(high)];
                }
            }
            map.put(v, i);
        }
        int res = 0;
        for(boolean b: odd){
            res = b ? res+1 : res;
        }
        return res;


    }

}
