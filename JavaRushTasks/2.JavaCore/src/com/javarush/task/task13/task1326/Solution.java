package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String ab = reader.readLine();
        //FileInputStream instream = new FileInputStream("F:/"+ab+".txt");
        //BufferedWriter instream = new BufferedWriter(new FileInputStream("F:/"+ab+".txt"));
       // BufferedReader instream = new BufferedReader(new InputStreamReader(new FileInputStream("F:/"+ab+".txt")));
        //FileReader instream = new FileReader("F:/"+ab+".txt");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        List<Integer> list = new  ArrayList<Integer>();
        while((line = in.readLine()) != null){
            if(Integer.parseInt(line) % 2 == 0) {
                list.add(Integer.parseInt(line));
            }
        }

        Collections.sort(list);

        for(Integer x : list){
            System.out.println(x);
        }

        in.close();
    }
}
