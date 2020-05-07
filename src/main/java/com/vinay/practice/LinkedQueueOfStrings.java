package com.vinay.practice;

public class LinkedQueueOfStrings {

    private Node first = null;
    private Node last = null;

    private class Node{
        String item;
        Node next;
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if(isEmpty()){
            first = last;
        }
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            old.next = last;
        }
    }

    public static void main(String[] args) {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        String st[] = "to be or not - to be is - the question".split(" ");
        System.out.println("Is stack Empty? " + queue.isEmpty());
        for(String str: st){
            if(str.equals("-")){
                System.out.println("Poopped item is " + queue.dequeue());
            }else {
                queue.enqueue(str);
            }
        }
        System.out.println("Is stack Empty? " + queue.isEmpty());
    }



}
