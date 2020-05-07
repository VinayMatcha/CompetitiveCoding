package com.vinay.codeChef;

import java.util.Scanner;

public class March3 {

    public static void main(String[] args) {
        try {
//            System.out.println(parityBit(4));
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();
                int[] aValues = new int[n];
                for(int i=0;i<n;i++) {
                    aValues[i] = sc.nextInt();
                }
                int[][] result = new int[q][2];
                int l = 0;
                for(int i=0;i<q;i++) {
                    int odd = 0;
                    int even = 0;
                    int p = sc.nextInt();
                    for(int j=0;j<n;j++) {
                        int val = p ^ aValues[j];
                        if(parityBit(val) == 0)
                            even++;
                        else
                            odd++;
                    }
                    result[l][0] = even;
                    result[l][1] = odd;
                    l++;
                }
                for(int i=0;i<q;i++) {
                    System.out.println(result[i][0] + " " + result[i][1]);
                }
            }

        } catch(Exception e) {
            return;
        }
    }

    private static int parityBit(int x) {
        x ^= x>>16;
        x ^= x>>8;
        x ^= x>>4;
        x ^= x>>2;
        x ^= x>>1;
        return x&1;

    }

}

//static final class InputReader {
//    private final InputStream stream;
//    private final byte[] buf = new byte[1024];
//    private int curChar;
//    private int numChars;
//
//    public InputReader(InputStream stream) {
//        this.stream = stream;
//    }
//
//    private int read() throws IOException {
//        if (curChar >= numChars) {
//            curChar = 0;
//            numChars = stream.read(buf);
//            if (numChars <= 0) {
//                return -1;
//            }
//        }
//        return buf[curChar++];
//    }
//
//    public final int readInt() throws IOException {
//        return (int) readLong();
//    }
//
//    public final long readLong() throws IOException {
//        int c = read();
//        while (isSpaceChar(c)) {
//            c = read();
//            if (c == -1) throw new IOException();
//        }
//        boolean negative = false;
//        if (c == '-') {
//            negative = true;
//            c = read();
//        }
//        long res = 0;
//        do {
//            res *= 10;
//            res += c - '0';
//            c = read();
//        } while (!isSpaceChar(c));
//        return negative ? -res : res;
//    }
//
//    public final int[] readIntArray(int size) throws IOException {
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = readInt();
//        }
//        return array;
//    }
//
//    public final long[] readLongArray(int size) throws IOException {
//        long[] array = new long[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = readLong();
//        }
//        return array;
//    }
//
//    public final String readString() throws IOException {
//        int c = read();
//        while (isSpaceChar(c)) {
//            c = read();
//        }
//        StringBuilder res = new StringBuilder();
//        do {
//            res.append((char) c);
//            c = read();
//        } while (!isSpaceChar(c));
//        return res.toString();
//    }
//
//    private boolean isSpaceChar(int c) {
//        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//    }
//}