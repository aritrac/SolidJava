package test.reflection.verification;

import test.reflection.ConcreteClass;

import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException{
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("test.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.journaldev.reflection.ConcreteClass

        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]

        Class<?> superClass = Class.forName("test.reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class test.reflection.BaseClass"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"

        Class<?>[] classes = concreteClass.getClasses();
        //[class test.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface test.reflection.ConcreteClass$ConcreteClassPublicInterface,
        //class test.reflection.BaseClass$BaseClassInnerClass,
        //class test.reflection.BaseClass$BaseClassMemberEnum]
        System.out.println(Arrays.toString(classes));

        //getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
        Class<?>[] explicitClasses = Class.forName("test.reflection.ConcreteClass").getDeclaredClasses();
        //prints [class test.reflection.ConcreteClass$ConcreteClassDefaultClass,
        //class test.reflection.ConcreteClass$ConcreteClassDefaultEnum,
        //class test.reflection.ConcreteClass$ConcreteClassPrivateClass,
        //class test.reflection.ConcreteClass$ConcreteClassProtectedClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicClass,
        //class test.reflection.ConcreteClass$ConcreteClassPublicEnum,
        //interface test.reflection.ConcreteClass$ConcreteClassPublicInterface]
        System.out.println(Arrays.toString(explicitClasses));

        Class<?> innerClass = Class.forName("test.reflection.ConcreteClass$ConcreteClassDefaultClass");
        //prints com.journaldev.reflection.ConcreteClass
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());
    }
}
