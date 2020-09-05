package com.aritra.sample;

class TestA {
    public void methodPublic(){
        methodPrivate();
    }

    protected void methodProtected(){
        methodPrivate();
    }

    void methodDefault(){
        methodPrivate();
    }

    private void methodPrivate(){}
}
