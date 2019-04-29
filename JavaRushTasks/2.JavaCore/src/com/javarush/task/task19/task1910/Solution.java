package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        reader.close();
        BufferedReader freader = new BufferedReader(new FileReader(fName1));
        BufferedWriter fwriter = new BufferedWriter(new FileWriter(fName2));

        StringBuilder sb = new StringBuilder();

        while (freader.ready()) {
            sb.append((char)freader.read());
        }
        freader.close();
        fwriter.write(sb.toString().replaceAll("[\\p{P}\\n]",""));
        fwriter.close();

    }
}
