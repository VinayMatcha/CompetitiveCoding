package com.vinay.practice;

public class ArrayStackOfStrings {
    String[] stack;
    int top = 0;
    public ArrayStackOfStrings(int n) {
        stack = new String[n];
    }

    public String pop(){
        String item = stack[--top];
        stack[top] = null;
        return item;
    }

    public String push(String item){
        return stack[top++] = item;
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
        int n = 10;
        ArrayStackOfStrings Stack = new ArrayStackOfStrings(n);
        String st[] = "- to be or not - to be is - the question".split(" ");
        System.out.println("Is stack Empty? " + Stack.isEmpty());
        for(String str: st){
            if(str.equals("-") && Stack.top > 0){
                System.out.println(Stack.pop());
            }else if(Stack.top < n && !str.equals("-")){
                Stack.push(str);
            }
        }
        System.out.println("Is stack Empty? " + Stack.isEmpty());
        Stack.print();
    }
}
