package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Салагаев", "Миша");
        map.put("Петров", "Денис");
        map.put("Семенова", "Лена");
        map.put("Крюков", "Павел");
        map.put("Полянский", "Виталий");
        map.put("Свиридович", "Даша");
        map.put("Шабанов", "Роман");
        map.put("Раджабов", "Рустам");
        map.put("Симонова", "Лена");
        map.put("Красикова", "Катя");
        return (HashMap<String, String>) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int counterSmeName = 0;
        for (String n : map.values()){
            if(n.equals(name)){
                counterSmeName++;
            }
        }
        return counterSmeName;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int LN = 0;
        for (String n : map.keySet()){
            if(lastName.equals(n))
                LN++;

        }
        return LN;

    }

    public static void main(String[] args) {

    }
}
