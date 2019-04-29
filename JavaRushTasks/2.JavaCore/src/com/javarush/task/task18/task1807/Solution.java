package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileInputStream inputStream = new FileInputStream(new File(reader.readLine()));
            int count = 0;
            while (inputStream.available() > 0) {
                if (inputStream.read() == 44) {
                    count++;
                }
            }
            reader.close();
            inputStream.close();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
