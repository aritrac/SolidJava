package test.synchronization.thread.safety.danger.hacks;

class MyObject2 {
    public Object lock = new Object();

    public void doSomething() {
        synchronized (lock) {
            // Do some processing here
        }
    }
}

public class ThreadDangerCase2 {
    //Don't run this method, it is infinite
    public static void main(String[] args) throws InterruptedException{
        //Hackers code
        //Start
        MyObject2 myObject = new MyObject2();
        //change the lock Object reference
        myObject.lock = new Object();
        //End
    }
}
