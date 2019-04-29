package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map =new HashMap<String, Integer>();;




        while (true) {


            String Id = reader.readLine();

            if (Id.isEmpty()) {
                break;
            }
            int id = Integer.parseInt(Id);
                String name = reader.readLine();
            if (name.isEmpty()) {
                map.put(name,id);
                break;
            }

                map.put(name,id);

    }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            String index = pair.getKey();
            Integer name = pair.getValue();
            System.out.println(name +  " " + index);
        }

}}
