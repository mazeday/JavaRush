package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        String filename = scn.nextLine();

        FileInputStream fileInputStream = new FileInputStream(filename);

        while (fileInputStream.available()>0)
        {
            Integer k = fileInputStream.read();
            treeMap.put(k, 1);
        }

        for (Map.Entry e : treeMap.entrySet())
        {
            System.out.print(e.getKey()+" ");
        }

        fileInputStream.close();
    }
}
