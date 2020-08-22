package test.threads;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }

}

class ThreadExample {

    public static void main(String[] args){
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        System.out.println("Starting the Threads");
        t1.start();
        t2.start();
        System.out.println("Threads has been started");
    }
}
