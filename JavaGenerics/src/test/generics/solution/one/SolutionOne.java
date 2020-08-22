package test.generics.solution.one;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        //Use generics in the list declaration which will permit only Strings to be stored in the collection
        List<String> list = new ArrayList<String>();
        //In java 7 you can write like below
        //List<String> list = new ArrayList<>();
        list.add("abc");
        //This line if uncommented will thrown compile time error as its an integer being stored in a string list
        //list.add(new Integer(5));

        //Now in the loop, when we iterate the above list as all elements are string, no exception will be thrown
        //while casting
        for(Object obj : list){
            //This is fine at compile time, but when run, you will hit the exception
            String str = (String)obj;
        }
    }
}
