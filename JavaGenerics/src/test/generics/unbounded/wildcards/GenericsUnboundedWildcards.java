package test.generics.unbounded.wildcards;

import java.util.List;

/*
Sometimes we have a situation where we want our generic method to be working with all types, in this case,
an unbounded wildcard can be used. Its same as using <? extends Object>.
 */

public class GenericsUnboundedWildcards {
    public static void printData(List<?> list){
        for(Object obj : list){
            System.out.print(obj + "::");
        }
    }
}
