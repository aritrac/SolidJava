package com.sample.aritra.intern;

public class StringInternExample {
    public static void main(String[] args) {

        String s1 = "Aritra";
        String s2 = "Aritra";
        String s3 = new String("Aritra");

        System.out.println(s1==s2);//true
        System.out.println(s2==s3);//false

        String s4 = s3.intern();
        System.out.println(s1==s4);//true

    }
}
