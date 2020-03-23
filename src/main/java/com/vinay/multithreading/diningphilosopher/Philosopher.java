package com.vinay.multithreading.diningphilosopher;

import java.util.Random;

public class Philosopher implements Runnable{

    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Random random;
    private int eatingCounter;
    private volatile boolean isFull;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }


    public void run() {

        try {
            while (!isFull) {
                think();
                if( leftChopstick.pickUp(this, State.LEFT) ) {
                    if (rightChopstick.pickUp(this, State.RIGHT) ) {
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }
                    leftChopstick.putDown(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating....");
        this.eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking....");
        Thread.sleep(random.nextInt(1000));
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Philospher " + id;
    }
}
