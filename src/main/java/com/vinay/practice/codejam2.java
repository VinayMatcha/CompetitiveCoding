package com.vinay.practice;

import java.util.Scanner;

public class codejam2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        System.out.println(t + " is");
        int l = 0;
        while(l++ < t){
            int p = Integer.parseInt(sc.nextLine());
            String a = sc.nextLine();
            StringBuilder st = new StringBuilder();
            for(int i=0;i< a.length();i++){
                if(a.charAt(i) == 'E'){
                    st.append('S');
                }else {
                    st.append('E');
                }
            }
            System.out.println("Case#" + l + ": " + st.toString());
        }
    }


}
