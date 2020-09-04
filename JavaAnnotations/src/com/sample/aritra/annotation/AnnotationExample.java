package com.sample.aritra.annotation;

import com.sample.aritra.custom.MethodInfo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
    public static void main(String[] args) {
    }

    @Override
    @MethodInfo(author = "Aritra", comments = "Main method", date = "Sep 01 2020", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Sep 01 2020")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @MethodInfo(author = "Aritra", comments = "Main method", date = "Sep 01 2020", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
