package com.javarush.task.task13.task1319;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Throwable{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ab = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:/"+ab+".txt"));
        while(true){
            String s = br.readLine();
            if(!s.equals("exit")){
                bw.write(s);
                bw.newLine();
            }else{
                bw.write(s);


                break;


            }

        }
        bw.close();
        br.close();
    }
}
