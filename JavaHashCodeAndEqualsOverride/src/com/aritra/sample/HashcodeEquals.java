package com.aritra.sample;

public class HashcodeEquals {
    public static void main(String[] args) {
        Student alex1 = new Student(1, "Alex");
        Student alex2 = new Student(1, "Alex");
        System.out.println("alex1 hashcode = " + alex1.hashCode());
        System.out.println("alex2 hashcode = " + alex2.hashCode());
        //Run the below statement by commenting out the equals method in Student class and see the difference
        System.out.println("Checking equality between alex1 and alex2 = " + alex1.equals(alex2));
    }
}
