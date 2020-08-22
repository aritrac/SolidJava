package test.generics.problem.two;

public class ProblemTwo {
    private Object t;

    public Object get() {
        return t;
    }

    public void set(Object t) {
        this.t = t;
    }

    public static void main(String args[]){
        ProblemTwo type = new ProblemTwo();
        type.set("Aritra");
        String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
                                          //if we set other objects instead of string
    }
}
