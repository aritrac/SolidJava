package test.regular.expressions;

import java.util.regex.Pattern;

public class PatternExample2 {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("(\\w\\d)\\1", "a2a2")); //true
        System.out.println(Pattern.matches("(\\w\\d)\\1", "a2b2")); //false
        System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB")); //true
        System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB")); //false
    }
}
