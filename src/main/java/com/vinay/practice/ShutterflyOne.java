package com.vinay.practice;

import java.util.*;

public class ShutterflyOne {

    public static class check{
        int key;
        int value;

        public check(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class MyComp implements Comparator<check>{

        @Override
            public int compare(check o1, check o2) {
                if(o1.value > o2.value){
                    return 1;
                }else if(o2.value > o1.value){
                    return -1;
                }else{
                    return (o1.key - o2.key);
                }
            }

    }



    public static int[] sortFrequency(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<check> tree = new TreeSet<check>(new MyComp());
        SortedSet<Map.Entry<String, Double>> sortedset = new TreeSet<Map.Entry<String, Double>>(
                new Comparator<Map.Entry<String, Double>>() {
                    @Override
                    public int compare(Map.Entry<String, Double> e1,
                                       Map.Entry<String, Double> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int key = (int) pair.getKey();
            int value = (int) pair.getValue();
            tree.add(new check(key, value));
        }
        int i = 0;
        Iterator value = tree.iterator();

        // Displaying the values after iterating through the set
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            check check1  = (check) value.next();
            int key = check1.key;
            int value1 = check1.value;
            while (value1-- > 0){
                arr[i++] = key;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 5, 4, 3};
        a = sortFrequency(a);
        for(int i : a){
            System.out.println(i);
        }
    }


}
