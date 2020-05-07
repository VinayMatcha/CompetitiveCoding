package com.vinay.practice;

public class ResiazingArrayStackOfStrings {

    String stack[] = new String[1];
    int top = 0;


    public String pop(){
        String item = stack[--top];
        stack[top] = null;
        if(top > 0 && top == stack.length/4){
            resize(stack.length/2);
        }
        return item;
    }

    public void push(String st){
        if(top == stack.length){
            resize(2*stack.length);
        }
        stack[top++] = st;
    }

    public void resize(int n){
        String newStack[] = new String[n];
        for(int i=0;i<top;i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void print(){
        for(int i=0;i<top;i++){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResiazingArrayStackOfStrings stack = new ResiazingArrayStackOfStrings();
        String st[] = "to be or not - to be is - the question - - -".split(" ");
        System.out.println("Is stack Empty? " + stack.isEmpty());
        for(String str: st){
//            System.out.println(stack.stack.length);
            if(str.equals("-")){
                System.out.println("Poopped item is " + stack.pop());
            }else {
                stack.push(str);
            }
        }
        System.out.println("Is stack Empty? " + stack.isEmpty());
        stack.print();
    }

}
