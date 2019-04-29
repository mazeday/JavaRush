package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String filename = scn.nextLine();
        int sum = 0;


        FileInputStream fileInputStream = new FileInputStream(filename);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        ArrayList<Integer> chisla = new ArrayList<Integer>();
        ArrayList<Integer> id = new ArrayList<Integer>();
        ArrayList<Integer> id2 = new ArrayList<Integer>();
        ArrayList<Integer> chisla2 = new ArrayList<Integer>();

        while (fileInputStream.available() > 0) {
            Integer k = fileInputStream.read();
            arrayList.add(k);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int g = 0; g < arrayList.size(); g++) {
                if (arrayList.get(i).equals(arrayList.get(g))) {
                    sum++;
                }
            }
            if (sum > 1) {
                chisla.add(sum);
                id.add(i);
                sum = 0;
            }
        }
        chisla2.addAll(chisla);

        for (int i = chisla2.size() - 1; i >= 0; i--) {
            for (int g = 0; g < i; g++) {
                if ((chisla2.get(g)) > (chisla2.get(g + 1))) {
                    Integer mda = chisla2.get(g);
                    chisla2.set(g, chisla2.get(g + 1));
                    chisla2.set(g + 1, mda);
                }
            }
        }

        for (int i = 0; i < chisla.size(); i++) {
            if (chisla.get(i).equals(chisla2.get(chisla2.size() - 1))) {
                id2.add(id.get(i));
            }
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < id2.size(); i++) {
            treeMap.put(arrayList.get(id2.get(i)), 1);
        }

        for (Map.Entry e : treeMap.entrySet())
        {
            System.out.print(e.getKey()+" ");
        }

        fileInputStream.close();
    }
}
