package test.systemclass;

import java.io.Console;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JavaSystemConsole {
    public static void main(String[] args) {
        Console console = System.console();

        if(console != null){
            Calendar c = new GregorianCalendar();
            console.printf("Welcome %1$s%n", "Aritra"); //prints "Welcome Pankaj"
            console.printf("Current time is: %1$tm %1$te,%1$tY%n", c); //prints "Current time is: 08 5,2013"
            console.flush();
        } else{
            //No console is attached when run as a background process
            System.out.println("No Console attached");
        }
    }
}
