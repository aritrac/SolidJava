package com.aritra.sample.example3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LazinessExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(findSquareOfMaxOdd(list));

        System.out.println(findSquareOfMaxOddLambda(list));
    }
    //Normal Method
    private static int findSquareOfMaxOdd(List<Integer> numbers) {
        int max = 0;
        for (int i : numbers) {
            if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
                max = i;
            }
        }
        return max * max;
    }

    public static int findSquareOfMaxOddLambda(List<Integer> numbers) {
        return numbers.stream()
                .filter(LazinessExample::isOdd) 		//Predicate is functional interface and
                .filter(LazinessExample::isGreaterThan3)	// we are using lambdas to initialize it
                .filter(LazinessExample::isLessThan11)	// rather than anonymous inner classes
                .max(Comparator.naturalOrder())
                .map(i -> i * i)
                .get();
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static boolean isGreaterThan3(int i){
        return i > 3;
    }

    public static boolean isLessThan11(int i){
        return i < 11;
    }
}
