package com.vinay.practice;

import java.io.IOException;

class AirPlane {
        public AirPlane() throws IOException {
            System.out.println("Airplane");
            throw  new IOException();
        }
}

class AirJet extends AirPlane {
    public AirJet() throws IOException {

    }
}

public class ImplC {
    public static void main(String[] args) {
        int[] a = {2};
        ImplC implC = new ImplC();
        implC.increment(a);
        System.out.println(a[a.length-1]);

    }

    private void increment(int[] a) {
        a[a.length-1]++;
    }

    private static void badMethgod() {
    }
}
