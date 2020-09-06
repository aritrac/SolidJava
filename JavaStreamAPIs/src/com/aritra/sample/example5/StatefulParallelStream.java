package com.aritra.sample.example5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StatefulParallelStream {
    public static void main(String[] args) {

        List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> result = new ArrayList<Integer>();

        Stream<Integer> stream = ss.parallelStream();

        /*
        If we run above program, you will get different results because it depends on the
        way stream is getting iterated and we don’t have any order defined for parallel processing.
        If we use sequential stream, then this problem will not arise.
         */
        stream.map(s -> {
            synchronized (result) {
                if (result.size() < 10) {
                    result.add(s);
                }
            }
            return s;
        }).forEach( e -> {});
        System.out.println(result);
    }
}
