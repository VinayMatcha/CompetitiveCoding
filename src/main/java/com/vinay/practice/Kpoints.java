package com.vinay.practice;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Kpoints {


    public static int[][] kClosest(int[][] points, int K) {
        if(points.length == 0){
            return null;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[][] res = new int[K][2];
        for(int i=0;i<points.length;i++){
            int a = points[i][0] *  points[i][0] +  points[i][1]* points[i][1];
            if(map.containsKey(a)){
                ArrayList<Integer> re = map.get(a);
                re.add(i);
                map.put(a, re);
            }else{
                ArrayList<Integer> re = new ArrayList<>();
                re.add(i);
                map.put(a, re);
            }

        }
        int i =0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> re = entry.getValue();
            for(int j=0;j<re.size()&&i<=K;j++){
                res[i][0] = points[re.get(j)][0];
                res[i][1] = points[re.get(j)][1];
                i++;
            }
            if(i==K){
                break;
            }
        }
        return res;
    }
//
//    public static void main(String[] args) {
//        int K = 2;
//        int[][] points = new int[3][2];
//        points[0][0] =
//                points[0][0] =
//                        points[0][0] =
//    }


}
