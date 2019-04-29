package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream realStream = System.out;
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(oStream);
        System.setOut(stream);
        testString.printSomething();
        String result = oStream.toString();
        System.setOut(realStream);
        String strarray[] = result.split(" ");
        int res=0;
        if (strarray[1].equals("+")) res = Integer.parseInt(strarray[0])+Integer.parseInt(strarray[2]);
        if (strarray[1].equals("*")) res = Integer.parseInt(strarray[0])*Integer.parseInt(strarray[2]);
        if (strarray[1].equals("-")) res = Integer.parseInt(strarray[0])-Integer.parseInt(strarray[2]);
        System.out.println(result+res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

