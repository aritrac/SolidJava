package com.aritra.sample.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4);

        Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4});
        //works fine

        //Stream<Integer> stream3 = Stream.of(new int[]{1,2,3,4});
        //Compile time error, Type mismatch: cannot convert from Stream<int[]> to Stream<Integer>

        //Sequential and parallel stream
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //Using generate and iterate
        Stream<String> streamX = Stream.generate(() -> {return "abc";});
        Stream<String> streamY = Stream.iterate("abc", (i) -> i);
    }
}
