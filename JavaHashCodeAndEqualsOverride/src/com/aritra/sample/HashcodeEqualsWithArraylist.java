package com.aritra.sample;

import java.util.ArrayList;
import java.util.List;

public class HashcodeEqualsWithArraylist {
    public static void main(String[] args) {
        Student alex = new Student(1, "Alex");
        List< Student > studentsLst = new ArrayList< Student >();
        studentsLst.add(alex);
        System.out.println("Arraylist size = " + studentsLst.size());
        //We get true below, because we overridden equals in student to compare the student id instead of the hashcode
        System.out.println("Arraylist contains Alex = " + studentsLst.contains(new Student(1, "Alex")));
    }
}
