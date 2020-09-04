package com.aritra.sample.anonymous;

import java.util.Arrays;

public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass(1,2,3,4);

        //static nested classes example
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        OuterClass.StaticNestedClass staticNestedClass1 = new OuterClass.StaticNestedClass();

        System.out.println(staticNestedClass.getName());
        staticNestedClass.d=10;
        System.out.println(staticNestedClass.d);
        System.out.println(staticNestedClass1.d);

        //inner class example
        OuterClass.InnerClass innerClass = outer.new InnerClass();
        System.out.println("Print1: " + innerClass.getName());
        System.out.println("Print2: " + innerClass);
        innerClass.setValues();
        System.out.println("Print3: " + innerClass);

        //calling method using local inner class
        outer.print("Outer");
        System.out.println("Done");
        //calling method using anonymous inner class
        System.out.println(Arrays.toString(outer.getFilesInDir("com/aritra/sample/anonymous", ".java")));

        System.out.println(Arrays.toString(outer.getFilesInDir("../../out/production/JavaInnerClasses/com/aritra/sample/anonymous", ".class")));
    }
}
