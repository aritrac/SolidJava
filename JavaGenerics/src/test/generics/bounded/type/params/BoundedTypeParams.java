package test.generics.bounded.type.params;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

public class BoundedTypeParams {
    //different ways of using bounded type params
    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }
    /*
    Java Generics supports multiple bounds also, i.e <T extends A & B & C>. In this case, A can be an interface or
    class. If A is class then B and C should be an interface. We can’t have more than one class in multiple bounds.
     */
    public static <T extends Random & Comparable, X extends Calendar & Serializable> int compare(T t1, X t2){
        System.out.println(t2);
        return -1;
    }
}
