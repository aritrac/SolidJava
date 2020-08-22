package test.exception.handling;

import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResourcesAndMultiCatchExample {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("aritra.txt")){
            //here the above file stream is now an auto-closeable resource, and jre will close it automatically
            //so no need for a finally block to release the resource
        }catch (IOException | ArrayIndexOutOfBoundsException ex){
            //here we catch multiple exception types with a single catch block
        }
    }
}
