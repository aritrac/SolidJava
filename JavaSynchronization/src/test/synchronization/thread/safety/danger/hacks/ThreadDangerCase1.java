package test.synchronization.thread.safety.danger.hacks;

class MyObject {
    //Locks on the object's monitor
    public synchronized void doSomething(){
        //consider some processing is happening here
    }
}

public class ThreadDangerCase1 {
    //Don't run this method, it is infinite
    public static void main(String[] args) throws InterruptedException{
        //Hackers code
        //Start
        MyObject myObject = new MyObject();
        synchronized (myObject) {
            while (true) {
                // Indefinitely delay myObject
                Thread.sleep(Integer.MAX_VALUE);
            }
        }
        //End
    }
}


