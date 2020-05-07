package com.vinay.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class depednd {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        while(s-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            set.add(a);
            set.add(b);
            set1.add(b);
            map.put(a, b);
        }
        int cal = set.size();
        Iterator<Integer> it = set1.iterator();
        while(it.hasNext()){
            set.remove(it.next());
        }

    }

}
