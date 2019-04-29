package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new FileReader(buff.readLine()));
        List<String> result = new ArrayList<>();
        while(filereader.ready()){
            String s = filereader.readLine();
            String tmp[] = s.split(" ");
            int count=0;
            for(int i=0;i<words.size();i++) {
                for(int j=0;j<tmp.length;j++)
                    if (tmp[j].equals(words.get(i)))
                        count++;
            }
            if(count==2)
                result.add(s);
        }
        buff.close();
        filereader.close();
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
}
