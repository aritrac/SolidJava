package test.serialization.inheritance;

import java.io.IOException;

import test.serialization.SerializationUtil;

public class InheritanceSerializationTest {

    public static void main(String[] args) {
        String fileName = "subclass.ser";

        SubClass subClass = new SubClass();
        subClass.setId(10);
        subClass.setValue("Data");
        subClass.setName("Aritra");

        try {
            SerializationUtil.serialize(subClass, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            SubClass subNew = (SubClass) SerializationUtil.deserialize(fileName);
            System.out.println("SubClass read = "+subNew);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
