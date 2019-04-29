package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 0; i < sb.length()-1; i++){
            if(Character.isSpaceChar(s.charAt(i))){
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
            }
        }
        System.out.println(sb);
    }
}
