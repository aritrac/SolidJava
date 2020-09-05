package com.aritra.sample;

public class TestB {
    public static void main(String args[]) {
        new TestA().methodPublic();
        new TestA().methodProtected();
        new TestA().methodDefault();

    }

    public void methodPublic() {

    }

    protected void methodProtected() {

    }

    void methodDefault() {

    }

    private void methodPrivate() {
    }}
