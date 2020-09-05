package com.aritra.sample.example1;

public class NormalExecution {
    public static void main(String[] args) {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("My Runnable");
            }};
        r.run();
    }
}
