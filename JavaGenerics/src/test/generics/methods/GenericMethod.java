package test.generics.methods;

public class GenericMethod {
    //Java Generic Method
    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2){
        return g1.get().equals(g2.get());
    }

    public static void main(String args[]){
        GenericType<String> g1 = new GenericType<>();
        g1.set("Aritra");

        GenericType<String> g2 = new GenericType<>();
        g2.set("Aritra");

        boolean isEqual = GenericMethod.<String>isEqual(g1, g2);
        //above statement can be written simply as
        //isEqual = GenericMethod.isEqual(g1, g2);
        //This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
        //Compiler will infer the type that is needed

        System.out.println(isEqual);
    }
}
