package com.vinay.practice;

import java.math.BigInteger;
import java.util.*;


public class Jam3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = Integer.parseInt(sc.next());
            int l = 0;
            while(l++ < t){
                BigInteger a = new BigInteger(sc.next());
                int p = sc.nextInt();
                List<BigInteger> alphas = new ArrayList<>();
                int i = 0;
                while(i < p){
                    alphas.add(new BigInteger(sc.next()));
                    i++;
                }
                TreeSet<BigInteger> StringSet = new TreeSet<>();
                List<BigInteger> values = new ArrayList<>();
                i = 0;
                while(i < p-1 && alphas.get(i).equals(alphas.get(i+1)))
                    i++;
//                System.out.println(i);
                BigInteger start = alphas.get(i).gcd(alphas.get(i+1));
                values.add(start);
                StringSet.add(start);
                BigInteger start1 = start;
                for(int j =i+1; j<p;j++){
                    start = alphas.get(j).divide(start);
                    values.add(start);
                    StringSet.add(start);
                }
                for(int j =i; j>=0;j--){
                    start1 = alphas.get(j).divide(start1);
                    values.add(0,start1);
                    StringSet.add(start1);
                }
                HashMap<BigInteger, Character> map = new HashMap<>();
                int ch = 0;
                if(StringSet.size() >= 0){
                    Iterator iterator = StringSet.iterator();
                    while(iterator.hasNext()){
                        BigInteger val = (BigInteger) iterator.next();
                        map.put(val, (char)('A' + ch));
                        ch++;
                    }
                }
                StringBuilder st = new StringBuilder();
                for(i=0;i<=p;i++){
                    st.append(map.get(values.get(i)));
                }
                System.out.println("Case #" + l + ": " + st.toString());
            }
        }

    }
