package com.aritra.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamSample {
    private static int sumIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    private static int sumStream(List<Integer> list) {
        return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(11);
        myList.add(12);
        myList.add(13);
        myList.add(14);

        System.out.println(sumIterator(myList));
        System.out.println(sumStream(myList));
    }
}
