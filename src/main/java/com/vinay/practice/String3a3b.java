package com.vinay.practice;

public class String3a3b {


    public static String strWithout3a3b(int A, int B) {
        StringBuilder st = new StringBuilder();
        if(A==B){
            while(A > 0){
                st.append("AB");
                A--;
            }
            return st.toString();
        }
        int Aextra = A - B;
        int BExtra = B - A;
        A = A - Aextra;
        B = B - BExtra;
        while(A > 0 && B > 0){
            st.append("a");
            if(Aextra > 0){
                st.append("a");
                Aextra--;
            }
            st.append("b");
            if(BExtra > 0){
                st.append("b");
                BExtra--;
            }
            A--;
            B--;
        }
        while (Aextra > 0){
            st.append("a");
            Aextra--;
        }
        st.reverse();
        while (BExtra > 0){
            st.append("b");
            BExtra--;
        }
        System.out.println(st.length());
        return st.toString();
    }


    public static void main(String[] args) {
        System.out.println(strWithout3a3b(6,2));
    }


}
