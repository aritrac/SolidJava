package test.generics.subtyping.using.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Example {
    List<? extends Integer> intList = new ArrayList<>();
    List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
}
