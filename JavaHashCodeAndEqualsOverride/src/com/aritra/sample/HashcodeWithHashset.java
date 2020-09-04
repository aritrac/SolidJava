package com.aritra.sample;

import java.util.HashSet;

public class HashcodeWithHashset {
    public static void main(String[] args) {
        Student alex1 = new Student(1, "Alex");
        Student alex2 = new Student(1, "Alex");
        HashSet < Student > students = new HashSet< Student >();
        students.add(alex1);
        students.add(alex2);
        System.out.println("HashSet size = " + students.size());
        //Here even though we have overridden the equals method in student, the hashcode will be taken into account
        //for Hashsets as it considers a different hashcode as a different object
        System.out.println("HashSet contains Alex = " + students.contains(new Student(1, "Alex")));
    }
}
