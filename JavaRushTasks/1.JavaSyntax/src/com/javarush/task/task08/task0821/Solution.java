package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map <String, String> map= new HashMap<String, String>();
        map.put("Петров","Вася");
        map.put("Семенов","Денис");
        map.put("Сидорович","Петр");
        map.put("Петров","Вася");
        map.put("Иванов","Петр");
        map.put("Комунист","Вася");
        map.put("Семенов","Денис");
        map.put("Петров","Вася");
        map.put("Забиулин","Вася");
        map.put("Петров","Вася");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
