package com.vinay.practice;

public class CapsLock {


    static String pressAForCapsLock(String message) {
        StringBuilder st = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<message.length();i++){
            if(message.charAt(i) == 'a' || message.charAt(i) =='A') {
                flag = !flag;
            }else if(flag){
                st.append(message.charAt(i));
            }else{
                st.append(Character.toUpperCase(message.charAt(i)));
            }
        }

        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(pressAForCapsLock("Vinay"));
    }

}
