package com.sample.aritra.definestring;

public class DeclareString {
    public static void main(String[] args) {
        //As string literal in string pool
        String str = "abc";

        //Using new keyword
        String str2 = new String("abc");
        char[] a = {'a','b','c'};
        //From a char sequence
        String str3 = new String(a);
    }
}
