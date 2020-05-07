package com.vinay.multithreading;


class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("We are in the produce method");
            wait(10000);
            System.out.println("Again Producer method");
        }
    }


    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("We are in the consume method");
            notifyAll();
            System.out.println("Again consume method");
        }
    }

}


public class BasicWaitAndNotify {


    public static void main(String[] args) {
        final Processor processor = new Processor();

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
