package com.vinay.multithreading;

public class BasicThread {

    public static void main(String[] args) {
        //concurrent execution
//        Runner1 runner1 = new Runner1();
//        Runner2 runner2 = new Runner2();
//
//        runner1.startRunning();
//        runner2.startRunning();

        Thread thread1 = new Thread(new Runner1());
        Thread thread2 = new Thread(new Runner2());
        thread1.start();
        thread2.start();
        System.out.println("Finsished the tasks");
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Correct Finishing of tasks");

    }

}

class Runner1 implements Runnable {

    public void run() {
        startRunning();
    }

    public void startRunning() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runner1  " + i);
        }
    }

}


class Runner2 implements Runnable {

    public void run() {
        startRunning();
    }

    public void startRunning() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runner2  " + i);
        }
    }

}