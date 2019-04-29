package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader f = new FileReader(args[0]);

        int spaceCount = 0;
        int charCount = 0;
        while (f.ready()) {
            char ch = (char) f.read();
            charCount++;

            if (ch == ' ')
                spaceCount++;

        }

        f.close();

        System.out.println(String.format("%.2f", ((float) spaceCount / charCount) * 100));

    }
}
