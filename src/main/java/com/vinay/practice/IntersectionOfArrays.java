package com.vinay.practice;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        HashMap<Integer, Integer> map1 = new HashMap();
        for(int i=0;i<nums1.length;i++){
            int p = nums1[i];
            if(map.containsKey(p)){
                map.put(p, map.get(p)+1);

            }else{
                map.put(p,1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            int p = nums2[i];
            if(map1.containsKey(p)){
                map1.put(p, map1.get(p)+1);

            }else{
                map1.put(p,1);
            }
        }
        ArrayList<Integer> res = new ArrayList();
        for(int i : map1.keySet()){
            if(map.containsKey(i)){
                int r = map1.get(i);
                int p = map.get(i);
                r = p > r ? r : p;
                while(r > 0){
                    res.add(i);
                    r--;
                }
            }
        }
        int result[] = new int[res.size()];
       // System.out.println(res.size());
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i) + " i");
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,2,1};
        int b[] = new int[]{2,2,1};
        System.out.println(intersect(a, b));
    }

}
