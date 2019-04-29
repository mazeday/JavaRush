package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> values = new ArrayList<>();
        for (Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); itr.hasNext(); ) {
            Map.Entry<String, String> pair = itr.next();
            values.add(pair.getValue());
        }
        String dup = " ";
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - 1; j++) {
                if (values.get(i).equals(values.get(j)) && i != j) {
                    dup = values.get(i);
                }
            }
            removeItemFromMapByValue(map, dup);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
