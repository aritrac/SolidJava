package test.systemclass;

public class JavaSystemMiscellaneousTasks {
    public static void main(String[] args) {
        //run the garbage collector
        System.gc();
        System.out.println("Garbage collector executed.");

        //map library name
        String libName = System.mapLibraryName("os.name");
        System.out.println("os.name library="+libName);

        //load external libraries
        System.load("lixXYZ.so");
        System.loadLibrary("libos.name.dylib");

        //run finalization
        System.runFinalization();

        //terminates the currently running JVM
        System.exit(1);

        // this line will never print because JVM is terminated
        System.out.println("JVM is terminated");
    }
}
