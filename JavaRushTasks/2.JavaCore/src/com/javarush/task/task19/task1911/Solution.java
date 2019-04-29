package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream realsys = System.out;
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(oStream);
        System.setOut(stream);
        testString.printSomething();
        String result = oStream.toString().toUpperCase();
        System.setOut(realsys);
        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
