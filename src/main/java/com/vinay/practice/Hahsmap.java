package com.vinay.practice;

import java.util.*;

public class Hahsmap {


    public static ArrayList<Integer> closest(String s, List<Integer> queries) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        int count1 = 0;
        for(char ch: arr){
            if(map.containsKey(ch)){
               continue;
            }else{
                TreeSet<Integer> ans = new TreeSet<>();
                int count = 0;
                int l = s.indexOf(ch, count);
                while(l!=-1){
                    count = l;
                    ans.add(l);
                    l = s.indexOf(ch, count+1);
                }
                map.put(ch, ans);
            }
            count1++;
        }
        for (int que: queries){
            char cha = arr[que];
            TreeSet<Integer> rt = map.get(cha);
            if(rt.size()==1){
                res.add(-1);
            }else{
                int low = -1;
                if((rt.floor(que-1)!= null)){
                    low = rt.floor(que-1);
                }
                int hight = -1;
                if((rt.ceiling(que+1)!= null)){
                    hight = rt.ceiling(que+1);
                }
                if(low ==-1){
                    res.add(hight);
                }else if(hight==-1){
                    res.add(low);
                }else{
                    if(que-low <= hight-que){
                        res.add(low);
                    }else{
                        res.add(hight);
                    }
                }
            }


        }


    return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = "avinaya";
        sc.next();

        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(0);
        ar.add(6);
        ar.add(2);
        ar = closest(st, ar);
        for(int s: ar){
            System.out.println(s);
        }


    }



}
