package com.vinay.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("In the Producer method");
        condition.await();
        System.out.println("Again in Produce method");
        lock.unlock();
    }


    public void consume() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println("In the Consumer method");
        condition.signal();
        System.out.println("Again in Consumer method");
        lock.unlock();
    }

}


public class BasicLock {

    public static void main(String[] args) {
        final Worker worker = new Worker();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.consume();
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
