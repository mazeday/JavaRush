package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Arnold", df.parse("JUNE 1 1980"));
        map.put("Rome", df.parse("JUNE 1 1980"));
        map.put("Denis", df.parse("JUNE 1 1980"));
        map.put("Petrov", df.parse("JUNE 1 1980"));
        map.put("Vasy", df.parse("JUNE 1 1980"));
        map.put("Idiote", df.parse("JUNE 1 1980"));
        map.put("Debil", df.parse("JUNE 1 1980"));
        map.put("Alena", df.parse("JUNE 1 1980"));
        map.put("Safary", df.parse("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {


        List<String> list=new ArrayList<String>();
        for (HashMap.Entry<String, Date> entry : map.entrySet()){
            if(entry.getValue().getMonth()>=5 & entry.getValue().getMonth()<=7){
                list.add(entry.getKey());

            }
        }
        for (String ln:list) {
            map.remove(ln);
        }
        //for (Date n: map.values()){
        //    if(n.getMonth()==6){

        //    }

        //}

    }

    public static void main(String[] args) throws ParseException {
        removeAllSummerPeople(createMap());
    }
}
