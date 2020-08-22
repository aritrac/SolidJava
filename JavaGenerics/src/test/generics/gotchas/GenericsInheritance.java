package test.generics.gotchas;

/*
We know that Java inheritance allows us to assign a variable A to another variable B if A is subclass of B.
So we might think that any generic type of A can be assigned to generic type of B, but it’s not the case.
Let’s see this with a simple program
We are not allowed to assign MyClass<String> variable to MyClass<Object> variable because they are not related,
in fact MyClass<T> parent is Object.
 */
public class GenericsInheritance {
    public static void main(String[] args) {
        String str = "abc";
        Object obj = new Object();
        obj=str; // works because String is-a Object, inheritance in java

        MyClass<String> myClass1 = new MyClass<String>();
        MyClass<Object> myClass2 = new MyClass<Object>();
        //myClass2=myClass1; // compilation error since MyClass<String> is not a MyClass<Object>
        obj = myClass1; // MyClass<T> parent is Object
    }

    public static class MyClass<T>{}
}
