package com.sample.aritra.stringpool;

public class StringPoolExample {
    public static void main(String[] args) {

        String a = "abc";
        String b = "abc";
        String c = "def";

        //same reference
        if (a==b) {
            System.out.println("Both string refer to the same object");
        }

        //different reference
        if (a==c) {
            System.out.println("Both strings refer to the same object");
        }else {
            System.out.println("Both strings refer to the different object");
        }

    }

}
