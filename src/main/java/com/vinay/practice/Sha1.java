package com.vinay.practice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Scanner;

public class Sha1 {

    public static String sha1(String st) throws NoSuchAlgorithmException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(st.getBytes());
        String sha1 = byteToHex(crypt.digest());
        return sha1;
    }

     public  static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int count = 0;
        while(st!=" "){
            st = sha1(st);
            System.out.println(st.length());
            System.out.println("https://sf.ly/" + st.substring(count, count + 8));
            count++;
            if(count == 25){
                count = 0;
            }
            String line;
            if(!(line = sc.nextLine()).isEmpty()){
                st = line;
            }else{
                st = " ";
            }

        }
    }

}
