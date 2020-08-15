package test.systemclass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JavaSystemFileIO {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("server.log");) {

            //set input stream
            System.setIn(fis);
            char c = (char) System.in.read();
            System.out.print(c); //prints the first character from input stream

            //set output stream
            System.setOut(new PrintStream(fos));
            System.out.write("Hi Aritra\n".getBytes());

            //set error stream
            System.setErr(new PrintStream(fos));
            System.err.write("Exception message\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
