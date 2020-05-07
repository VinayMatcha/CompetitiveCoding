package com.vinay.practice;

public class LinkedStatckOfStrings {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    public static void main(String[] args) {
        LinkedStatckOfStrings stack = new LinkedStatckOfStrings();
        String st[] = "to be or not - to be is - the question".split(" ");
        System.out.println("Is stack Empty? " + stack.isEmpty());
        for(String str: st){
            if(str.equals("-")){
                System.out.println("Poopped item is " + stack.pop());
            }else {
                stack.push(str);
            }
        }
        System.out.println("Is stack Empty? " + stack.isEmpty());
    }

}
