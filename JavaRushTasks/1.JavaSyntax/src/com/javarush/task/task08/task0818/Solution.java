package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Салагаев", 100);
        map.put("Петров", 500);
        map.put("Семенова", 600);
        map.put("Крюков", 700);
        map.put("Полянский", 800);
        map.put("Свиридович", 1000);
        map.put("Шабанов", 5000000);
        map.put("Раджабов", 10);
        map.put("Симонова", 250);
        map.put("Красикова", 670);
        return (HashMap<String,Integer>) map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        List<String> list=new ArrayList<String>();
        for (HashMap.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()<500){
                list.add(entry.getKey());

            }
        }
        for (String ln:list) {
            map.remove(ln);
        }
    }

    public static void main(String[] args) {

    }
}