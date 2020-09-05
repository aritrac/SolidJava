package com.aritra.sample.example1;

public class LambdaExecution {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("My Runnable");
        r1.run();
    }
}
