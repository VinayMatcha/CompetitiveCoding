package com.vinay.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PairSongs {

    static long playlist(List<Integer> songs) {
        HashMap<Integer, Integer> set = new HashMap<>();
        HashSet<Integer> set1 = new HashSet<>();
        int count = 0;
        for(int i=0;i<songs.size();i++){
            int s = songs.get(i)%60;
            if(set.containsKey(s)){
                set.put(s, set.get(s)+1);
            }else{
                set.put(s, 1);
                set1.add(s);
            }
        }
        for(int s: set1){
            System.out.println(s+ " "+set.get(s));
            if(set.containsKey(60-s) && s!=30){
                System.out.println(s + " " + (60-s) );
                count += set.get(s)*set.get(60-s);
                set.remove(s);
            }else if(s==30){
                count += set.get(s) * (set.get(s)-1)/2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> songs = new ArrayList<>();
        songs.add(10);
        songs.add(50);
        songs.add(90);
        songs.add(30);
        System.out.println(playlist(songs));
    }



}
