package test.regular.expressions;

import java.util.regex.*;

public class PatternExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".xx.");
        Matcher matcher = pattern.matcher("MxxY");
        System.out.println("Input String matches regex - "+matcher.matches());
        // bad regular expression
        //pattern = Pattern.compile("*xx*");
        String str = "bbb";
        System.out.println("Using String matches method: "+str.matches(".bb"));
        System.out.println("Using Pattern matches method: "+Pattern.matches(".bb", str));

        //Matches any single character -> .
        System.out.println(Pattern.matches("..","a%"));
        System.out.println(Pattern.matches("..",".a"));
        System.out.println(Pattern.matches("..","a"));

        //Matches aaa regex at the beginning of the line -> ^aaa
        System.out.println(Pattern.matches("^a.c.","abcd"));
        System.out.println(Pattern.matches("^a","ac"));

        //Matches regex aaa at the end of the line -> aaa$
        System.out.println(Pattern.matches("..cd$","abcd"));
        System.out.println(Pattern.matches("a$","a"));
        System.out.println(Pattern.matches("a$","aca"));

        //Can match any of the letter a,b or c. [] are known as character classes. -> [abc]
        System.out.println(Pattern.matches("^[abc]d.", "ad9"));
        System.out.println(Pattern.matches("[ab].d$", "bad"));
        System.out.println(Pattern.matches("[ab]x", "cx"));

        //Can match a,b or c followed by 1 or 2 -> [abc][12]
        System.out.println(Pattern.matches("[ab][12].", "a2#"));
        System.out.println(Pattern.matches("[ab]..[12]", "acd2"));
        System.out.println(Pattern.matches("[ab][12]", "c2"));

        //Matching anything except a b and c -> [^abc]
        System.out.println(Pattern.matches("[^ab][^12].", "c3#"));
        System.out.println(Pattern.matches("[^ab]..[^12]", "xcd3"));
        System.out.println(Pattern.matches("[^ab][^12]", "c2"));

        //Matches ranges between a to e or 1 to 8 -> [a-e1-8]
        System.out.println(Pattern.matches("[a-e1-3].", "d#"));
        System.out.println(Pattern.matches("[a-e1-3]", "2"));
        System.out.println(Pattern.matches("[a-e1-3]", "f2"));

        //Matches regex xx or yy -> xx|yy
        System.out.println(Pattern.matches("x.|y", "xa"));
        System.out.println(Pattern.matches("x.|y", "y"));
        System.out.println(Pattern.matches("x.|y", "yz"));
    }
}
