package com.vinay.multithreading;

import java.util.ArrayList;
import java.util.List;

class Processor1 {

    private List<Integer> list = new ArrayList<Integer>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if(list.size() == LIMIT) {
                    System.out.println("waiting for removing items from list");
                    lock.wait();
                } else {
                    System.out.println("Adding " + value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }


    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (lock) {
            while(true) {
                if(list.size() == BOTTOM) {
                    System.out.println("waiting for adding items ot the list");
                    lock.wait();
                } else {

                    System.out.println("Removed value is " + list.remove(--value));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

}


public class ProducerConsumer {

    public static void main(String[] args) {
        final Processor1 processor = new Processor1();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

}
