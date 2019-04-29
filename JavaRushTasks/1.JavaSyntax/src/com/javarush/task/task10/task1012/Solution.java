package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<>();
        Integer kolvo;

        for(int a =0; a < alphabet.size(); a++) {
            kolvo=0;
            for(int b =0; b<list.size();b++){
                for (int c=0;c<list.get(b).length();c++) {

                    if (list.get(b).substring(c, c + 1).equals(alphabet.get(a).toString())) {
                        kolvo++;
                    }


                }


            }
            System.out.println(alphabet.get(a) + " " + kolvo);
           // map.put(alphabet.get(a),kolvo);
        }
        //System.out.println(list.get(0).substring(1,2));
/*
        for (Map.Entry<Character, Integer> pair : map.entrySet())
        {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " " + value);
        }
        */


    }

}
