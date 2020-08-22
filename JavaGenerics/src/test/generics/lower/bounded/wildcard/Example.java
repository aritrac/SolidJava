package test.generics.lower.bounded.wildcard;

import java.util.List;

/*
Suppose we want to add Integers to a list of integers in a method, we can keep the argument type as
List<Integer> but it will be tied up with Integers whereas List<Number> and List<Object> can also hold integers,
so we can use a lower bound wildcard to achieve this. We use generics wildcard (?) with super keyword and lower
bound class to achieve this.
 */

public class Example {
    public static void addIntegers(List<? super Integer> list){
        list.add(new Integer(50));
    }
}
