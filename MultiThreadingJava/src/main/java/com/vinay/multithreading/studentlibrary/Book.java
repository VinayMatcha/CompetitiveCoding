package com.vinay.multithreading.studentlibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(student + " is reading the book " + this);
            Thread.sleep(2000);
            lock.unlock();
            System.out.println(student + " releases the book " + this);
        }
    }

    @Override
    public String toString() {
        return "Book id: " + id;
    }
}
