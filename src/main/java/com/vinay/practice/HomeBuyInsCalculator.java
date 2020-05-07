package com.vinay.practice;

import java.util.HashMap;
import java.util.Scanner;

public class HomeBuyInsCalculator {

    static String sanjay = "s";
    static String vinay = "v";
    static String prashanth = "p";
    static String naren =  "n";
    static HashMap<String,Float> finalValues = new HashMap<String, Float>();;
    public static void main(String[] args) {
        finalValues.put(sanjay, (float) 0);
        finalValues.put(vinay,0f);
        finalValues.put(prashanth,0f);
        finalValues.put(naren,0f);
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter #$ to end");
        String str = scanner.nextLine();
        while(!str.equals("#$")){
            String[] div = str.split(" ");
            float rate = Float.valueOf(div[0]);
            if(div.length>1){
                if(div[1].equals("all")){
                    float invid = rate/4;
                    for(String key: finalValues.keySet()){
                        finalValues.put(key,finalValues.get(key)+invid);
                    }
                }else {
                    String independent[] = div[1].split("");
                    float invid = rate / independent.length;
                    for (int i = 0; i < independent.length; i++) {
                        if (finalValues.containsKey(independent[i])) {
                            finalValues.put(independent[i], finalValues.get(independent[i]) + invid);
                        } else {
                            System.out.println("you fucked while printing enter again");
                            for(int j=0;j<i;j++){
                                finalValues.put(independent[j], finalValues.get(independent[j]) - invid);
                            }
                            break;
                        }
                    }
                }
            }else{
                float invid = rate/4;
                for(String key: finalValues.keySet()){
                    finalValues.put(key,finalValues.get(key)+invid);
                }
            }
            str = scanner.nextLine();
        }
        for(String key: finalValues.keySet()){
            System.out.println(key + " " + finalValues.get(key));
        }
    }
}
