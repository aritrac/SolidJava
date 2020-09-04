package com.sample.aritra.example2;

import com.sample.aritra.ThreadStates;

public class EnumAndConstantsTest {
    private static void benefitsOfEnumOverConstants() {
        //Enum values are fixed
        simpleEnumExample(ThreadStates.START);
        simpleEnumExample(ThreadStates.WAITING);
        simpleEnumExample(ThreadStates.RUNNING);
        simpleEnumExample(ThreadStates.DEAD);
        simpleEnumExample(null);

        simpleConstantsExample(1);
        simpleConstantsExample(2);
        simpleConstantsExample(3);
        simpleConstantsExample(4);
        //we can pass any int constant
        simpleConstantsExample(5);
    }

    private static void simpleEnumExample(ThreadStates th) {
        if(th == ThreadStates.START) System.out.println("Thread started");
        else if (th == ThreadStates.WAITING) System.out.println("Thread is waiting");
        else if (th == ThreadStates.RUNNING) System.out.println("Thread is running");
        else System.out.println("Thread is dead");
    }

    private static void simpleConstantsExample(int i) {
        if(i == ThreadStateConstants.START) System.out.println("Thread started");
        else if (i == ThreadStateConstants.WAITING) System.out.println("Thread is waiting");
        else if (i == ThreadStateConstants.RUNNING) System.out.println("Thread is running");
        else System.out.println("Thread is dead");
    }
}
