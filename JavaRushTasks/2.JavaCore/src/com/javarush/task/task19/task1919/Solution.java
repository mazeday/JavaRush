package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String,Double> map = new TreeMap<>();
        List<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        for(int i=0;i<list.size();i++)
        {
            String names[] = list.get(i).split("\\s");
            if(map.containsKey(names[0])){
                double d=map.get(names[0])+Double.parseDouble(names[1]);
                map.put(names[0],d);
            }
            else map.put(names[0],Double.parseDouble(names[1]));
        }

        for(Map.Entry<String,Double> pair:map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}