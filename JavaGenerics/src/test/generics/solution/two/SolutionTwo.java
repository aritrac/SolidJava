package test.generics.solution.two;

public class SolutionTwo<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String args[]){
        //We specifically create the object for string type
        SolutionTwo <String> type = new SolutionTwo<>();
        type.set("Aritra"); //Valid

        //Here we dont specify the type and create the default raw type
        SolutionTwo type1 = new SolutionTwo(); //raw type
        type1.set("Aritra"); //valid
        type1.set(10); //valid and autoboxing support
    }
}
