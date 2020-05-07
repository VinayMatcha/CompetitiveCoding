package com.vinay.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class codejam3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            BigInteger n = new BigInteger(in.next());
            int l = in.nextInt();
            List<BigInteger> ciphertext = new ArrayList<>();
            for (int j = 0; j < l; ++j) {
                ciphertext.add(new BigInteger(in.next()));
            }
            List<BigInteger> factored = new ArrayList<>();
            int point;
            for (point = 0; ciphertext.get(point).equals(ciphertext.get(point + 1)); ++point);
            BigInteger n0 = ciphertext.get(point);
            BigInteger n1 = ciphertext.get(point + 1);
            BigInteger factor = n0.gcd(n1);
            factored.add(factor);
            BigInteger factor0 = factor;
            for (int j = point; j >= 0; --j) {
                factor0 = ciphertext.get(j).divide(factor0);
                factored.add(0, factor0);
            }
            for (int j = point + 1; j < l; ++j) {
                factor = ciphertext.get(j).divide(factor);
                factored.add(factor);
            }
            TreeSet<BigInteger> primes = new TreeSet<>(factored);
            HashMap<BigInteger, Integer> primeMap = new HashMap<>();
            Iterator<BigInteger> it = primes.iterator();
            int index = 0;
            while (it.hasNext()) {
                primeMap.put(it.next(), index++);
            }
            StringBuilder plaintext = new StringBuilder();
            for (int j = 0; j < l + 1; ++j) {
                plaintext.append((char)('A' + primeMap.get(factored.get(j))));
            }
            System.out.println("Case #" + i + ": " + plaintext.toString());
        }
    }
}
