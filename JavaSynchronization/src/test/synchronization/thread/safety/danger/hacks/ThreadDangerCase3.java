package test.synchronization.thread.safety.danger.hacks;

class MyObject3 {
    //locks on the class object's monitor
    public static synchronized void doSomething() {
        // Do some processing here
    }
}

public class ThreadDangerCase3 {
    //Don't run this method, it is infinite
    public static void main(String[] args) throws InterruptedException{
        //Hackers code
        //Start
        synchronized (MyObject3.class) {
            while (true) {
                Thread.sleep(Integer.MAX_VALUE); // Indefinitely delay MyObject3
            }
        }
        //End
    }
}
