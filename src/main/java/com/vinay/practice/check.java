package com.vinay.practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {

//    public HashMap<String, Integer> calculateCount(HashMap<String, ArrayList> topics, List<String> reviews){
//        HashMap<String, Integer> res = new HashMap<String, Integer>();
//        Pattern pattern = Pattern.compile("\"sunday\":\"\\[\\[\"(\\d|:)+\"");
//        for(int i=0;i<reviews.size();i++) {
//            String review = reviews.get(i);
//            String[] arr=review.split("[, !.]");
//            HashSet<String> set = new HashSet<String>();
//            for(int j=0;j<arr.length;j++) {
//                if(arr[j]!="")
//                    set.add(arr[j].toLowerCase());
//            }
//
//            for (Map.Entry me : topics.entrySet()) {
//
//                // System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
//                boolean flag=false;
//                ArrayList<String> keywords=(ArrayList<String>) me.getValue();
//                for(int k=0;k<keywords.size();k++) {
//                    String word = keywords.get(k).toLowerCase();
//                    if(word.contains(" ")) {
//                        String word_space[]=word.split(" ");
//                        boolean all=true;
//                        for(int x=0;x<word_space.length;x++) {
//                            String w=word_space[x].toLowerCase();
//                            if(!set.contains(word_space[x])) {
//                                all=false;
//                                break;
//                            }
//                        }
//
//                        if(all) {
//                            flag=true;
//                            break;
//                        }
//
//                        //do here
//                    } else {
//                        if(set.contains(word)) {
//                            flag=true;
//                            break;
//                        }
//
//                    }
//                }
//
//                if(flag == true) {
//                    if(res.containsKey(me.getKey())) {
//                        int count=res.get(me.getKey());
//                        res.put(me.getKey().toString(), count+1);
//                    }else
//                    {
//                        res.put(me.getKey().toString(),1);
//                    }
//                }
//
//            }
//
//
//
//        }
//        return res;
//    }

    public static void main(String[] args) {
        check s= new check();

//        ArrayList<String> li1=new ArrayList<String>();
//        li1.add("cheap");
//        li1.add("expensive");
//        li1.add("price");
//
//        ArrayList<String> li2=new ArrayList<String>();
//        li2.add("gnome");
//        li2.add("gnomes");
//
//        ArrayList<String> li3=new ArrayList<String>();
//        li3.add("harry shrub");
//
//        HashMap<String,ArrayList> map = new HashMap<String, ArrayList>();
//        map.put("Price",li1 );
//        map.put("Business Specialists", li2);
//        map.put("Harry Shrub", li3);
//
//        List<String> review = new ArrayList<String>();
//        review.add("Harry Shrub did a great job with my garden, but I expected more gnomes for the price");
//        review.add("I love my new gnomes, they are so cute! My dog loves them too! Thanks Harry!");
//        review.add("Very Expensive fifty dollars oer gnome. Next time I'll buy from cheap Gnomes Warehouse");
//        System.out.println(s.calculateCount(map, review));
//        String[] st = new String[] {"Boston", "Mexican", "100"};
//        String[] st1 = new String[] {"Boston", "American", "100"};
//        String[][] str = new String[][] {st, st1};
//        solution2(str);
        stringCheck("xxx", "zzz");

    }


    public long solution1(String[] businesses) {
        // Type your solution here
        Pattern pattern = Pattern.compile("\"sunday\":\\[\\[\"(\\d)+");
        for(String st : businesses) {
//            System.out.println(st.replaceAll(" ", "").replaceAll("\\\\\"", "\""));
            Matcher matcher = pattern.matcher(st.replaceAll(" ", "").replaceAll("\\\\\"", "\""));
            System.out.println(matcher.groupCount());
            while(matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }

        return 0l;
    }


    public static long[][] solution2(String[][] inputTable) {
        // Type your solution here
        HashSet<String> cities = new HashSet();
        HashSet<String> categories = new HashSet();
        HashMap<String, HashMap<String, Long>> cities_list = new HashMap();
        for(int i=0;i<inputTable.length;i++){
            String city = inputTable[i][0];
            String category = inputTable[i][1];
            categories.add(category);
            cities.add(city);
            if(cities_list.containsKey(city)) {
                HashMap<String, Long> map = cities_list.get(city);
                map.put(category, Long.parseLong(inputTable[i][2]));
            } else {
                HashMap<String, Long> map = new HashMap();
                map.put(category, Long.parseLong(inputTable[i][2]));
                cities_list.put(city, map);
            }
        }
         List<String> cities1 = new ArrayList(cities);
         Collections.sort(cities1);
         List<String> categories1 = new ArrayList(categories);
         Collections.sort(categories1);
        long[][] result = new long[cities.size()][categories.size()];
         for(int i=0;i<cities1.size();i++) {
             String city = cities1.get(i);
             HashMap<String, Long> map = cities_list.get(city);
             for(int j=0;j<categories1.size();j++) {
 //                 String category = categories1.get(j);
                 result[i][j] = (long) map.get(categories1.get(j));
                 System.out.print(result[i][j] + " ");
             }
             System.out.println();
         }
        return result;
    }

    public static void stringCheck(String a, String b) {
        String[] st = new String[] {a, b};
        Arrays.sort(st, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int start = 0;
                while (start < o1.length()) {
                    char a1 = o1.charAt(start);
                    char a2 = o2.charAt(start);
                    if (a1 > a2)
                        return 1;
                    else if(a2 > a1)
                        return -1;
                    start++;
                }
                return 0;
            }
        });
        System.out.println(st[0] + " " + st[1]);

    }


}