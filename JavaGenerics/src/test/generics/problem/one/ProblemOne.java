package test.generics.problem.one;

import java.util.ArrayList;
import java.util.List;

public class ProblemOne {
    public static void main(String[] args) {
        List list = new ArrayList();
        //Lets add different data types to the list which is permitted
        list.add("abc");
        list.add(new Integer(5));

        //Now in the loop, when we iterate the above list we see a ClassCastException (A runtime exception) is thrown when converting
        //the integer to string
        for(Object obj : list){
            //This is fine at compile time, but when run, you will hit the exception
            String str = (String)obj;
        }
        //Check solution.one for the fix
    }
}
