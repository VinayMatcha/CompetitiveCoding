package com.vinay.practice;

import java.util.*;

public class DAGCheck {
        // If you need extra classes, you can define them privately here within class Solution
    // Prints to standard output.
    static String findMidpointCourse(String[][] pairs) {
        // Your code here.
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            set.add(pairs[i][0]);
            map.put(pairs[i][0], pairs[i][1]);
        }
        for (int i = 0; i < pairs.length; i++) {
            String check = pairs[i][1];
            if (set.contains(check)) {
                set.remove(check);
            }
        }
        List<String> list = new ArrayList<>();
        if (set.size() != 0) {
            Iterator<String> it = set.iterator();
            String key = it.next();
            System.out.println(key);
            list.add(key);
            while (map.containsKey(key)) {
                key = map.get(key);
//                System.out.println("hi "+key);
                list.add(key);
            }
            return list.get(list.size() / 2);
        }

        return null;
    }

        // DO NOT MODIFY MAIN()
        public static void main(String[] args) {
            int n = 3;
            String[][] pairs = new String[n][n];
            Scanner scanner = new Scanner(System.in);
            for(int i=0;i<n;i++){
                String[] st = scanner.nextLine().split(" ");
                pairs[i][0] = st[0];
                pairs[i][1] = st[1];
            }
            System.out.println("hi ");
            System.out.println(findMidpointCourse(pairs));
        }


}
