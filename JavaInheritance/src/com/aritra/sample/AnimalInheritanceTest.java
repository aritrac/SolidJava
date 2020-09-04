package com.aritra.sample;

public class AnimalInheritanceTest {
    public static void main(String[] args) {
        Cat cat = new Cat(false, "milk", 4, "black");

        System.out.println("Cat is Vegetarian?" + cat.isVegetarian());
        System.out.println("Cat eats " + cat.getEats());
        System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
        System.out.println("Cat color is " + cat.getColor());

        //Upcasting
        Cat c = new Cat(false, "milk", 4, "black"); //subclass instance
        Animal a = c; //upcasting, its fine since Cat is also an Animal

        //Downcasting
        Cat c2 = new Cat(false, "milk", 4, "black");
        Animal a2 = c2;
        Cat c3 = (Cat) a2; //explicit casting, works fine because c2 is actually of type Cat

        //Casting exception
        Dog d = new Dog(false, "milk", 4, "black");
        Animal a3 = d;
        //Cat c4 = (Cat) a3; //ClassCastException at runtime, at compile time it will be fine

        Animal a4 = new Animal();
        //Cat c5 = (Cat)a4; //ClassCastException because a1 is actually of type Animal at runtime.

        //Using instance of operator to determine types at runtime

        Cat c10 = new Cat(false, "milk", 4, "black");
        Dog d10 = new Dog(false, "milk", 4, "black");
        Animal an10 = c10;

        boolean flag = c10 instanceof Cat; //normal case, returns true
        System.out.println("OP1: " + flag);

        flag = c10 instanceof Animal; // returns true since c is-an Animal too
        System.out.println("OP2: " + flag);

        flag = an10 instanceof Cat; //returns true because a is of type Cat at runtime
        System.out.println("OP3: " + flag);

        flag = an10 instanceof Dog; //returns false for obvious reasons.
        System.out.println("OP4: " + flag);
    }
}
