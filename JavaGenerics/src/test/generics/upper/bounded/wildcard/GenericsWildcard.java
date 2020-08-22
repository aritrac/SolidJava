package test.generics.upper.bounded.wildcard;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcard {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(5); ints.add(10);
        double sum = sum(ints);
        System.out.println("Sum of ints = "+sum);

        List<Double> doubles = new ArrayList<>();
        doubles.add(3.1); doubles.add(5.2); doubles.add(7.3);
        double sumOfDoubles = sum(doubles);
        System.out.println("Sum of doubles = "+sumOfDoubles);
    }

    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
    /*
    In the above method we can use all the methods of upper bound class Number. Note that with upper bounded list,
    we are not allowed to add any object to the list except null. If we will try to add an element to the list inside
    the sum method, the program won’t compile.
     */
}
