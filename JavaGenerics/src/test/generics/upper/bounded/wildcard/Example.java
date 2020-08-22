package test.generics.upper.bounded.wildcard;

import java.util.List;

public class Example {
    public static double sum(List<Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
    /*
    the problem with above implementation is that it won’t work with List of Integers or Doubles because we
    know that List<Integer> and List<Double> are not related, this is when an upper bounded wildcard is helpful.
    We use generics wildcard with extends keyword and the upper bound class or interface that will allow us to pass
    argument of upper bound or it’s subclasses types
     */
}
