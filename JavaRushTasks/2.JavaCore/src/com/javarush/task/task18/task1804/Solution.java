package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Byte, Integer> letters = new HashMap<Byte, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileInputStream in = new FileInputStream(new File(file));
        byte[] buffer = new byte[in.available()];
        if (in.available() > 0) {
            in.read(buffer);
        }
        in.close();
        for (byte c : buffer) {
            int count = 0;
            for (byte c1 : buffer) {
                if (c == c1)
                    count++;
            }
            letters.put(c, count);
        }
        int Maxbyte = 1000;
        for (Map.Entry<Byte, Integer> pair : letters.entrySet()) {
            if (pair.getValue() < Maxbyte)
                Maxbyte = pair.getValue();
        }
        for (Map.Entry<Byte, Integer> pair : letters.entrySet()) {
            if (pair.getValue().equals(Maxbyte))
                System.out.print(pair.getKey() + " ");
        }
    }
}
