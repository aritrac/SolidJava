package com.sample.aritra.replace;

public class StringReplaceExample {
    public static void main(String[] args) {

        //replace(char oldChar,  char newChar)
        String s = "Hello World";
        s = s.replace('l', 'm');
        System.out.println("After Replacing l with m :");
        System.out.println(s);

        //replaceAll(String regex, String replacement)
        String s1 = "Hello Aritra, Hello Ankita";
        s1 = s1.replaceAll("Hello", "Hi");
        System.out.println("After Replacing :");
        System.out.println(s1);

        //replaceFirst(String regex, String replacement)
        String s2 = "Hello guys, Hello world";
        s2 = s2.replaceFirst("Hello", "Hi");
        System.out.println("After Replacing :");
        System.out.println(s2);

    }
}
