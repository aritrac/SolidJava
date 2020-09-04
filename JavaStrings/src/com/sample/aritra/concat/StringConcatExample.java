package com.sample.aritra.concat;

public class StringConcatExample {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        //using + operator
        System.out.println("Using + operator: ");
        System.out.println(s3);

        //using concat method
        System.out.println("Using concat method: ");
        System.out.println(s1.concat(s2));

    }
}
