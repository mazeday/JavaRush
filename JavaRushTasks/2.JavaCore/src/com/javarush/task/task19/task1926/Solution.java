package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();
        BufferedReader freader = new BufferedReader(new FileReader(fName));
        StringBuilder sb;
        while (freader.ready()) {
            sb = new StringBuilder();
            sb.append(freader.readLine());
            sb.reverse();
            System.out.println(sb.toString());
        }
        freader.close();
    }
}
