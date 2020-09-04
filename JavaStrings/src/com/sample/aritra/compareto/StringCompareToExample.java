package com.sample.aritra.compareto;

public class StringCompareToExample {
    public static void main(String[] args) {

        String a1 = "abc";
        String a2 = "abc";
        String a3 = "def";
        String a4 = "ABC";

        System.out.println(a1.compareTo(a2));//0
        System.out.println(a2.compareTo(a3));//less than 0
        System.out.println(a1.compareTo(a4));//greater than 0
        System.out.println(a1.compareToIgnoreCase(a4));//0
    }
}
