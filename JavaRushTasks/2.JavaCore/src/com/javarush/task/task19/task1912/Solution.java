package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream regularstream = System.out;
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(oStream);
        System.setOut(stream);
        testString.printSomething();
        String result=oStream.toString();
        System.setOut(regularstream);
        System.out.println(result.replaceAll("te","??"));
        oStream.close();
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
