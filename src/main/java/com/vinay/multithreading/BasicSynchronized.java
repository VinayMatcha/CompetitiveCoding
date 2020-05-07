package com.vinay.multithreading;

public class BasicSynchronized {

    private static int counter = 0;
    private static int counter2 = 0;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static  void increment() {
        synchronized (lock1) {
            counter++;
        }
    }

    public static void incrementCounter2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    incrementCounter2();
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        process();
        System.out.println("counter value is " + counter + " and counter2 is " + counter2);
    }

}
