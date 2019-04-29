package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine().replaceAll("\n\r", ""));
        }
        fileReader.close();
        for (String str : splitFile(sb.toString(), args[0])) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> splitFile(String htmlFile, String tag) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        ArrayDeque<Integer> startArrayDeque = new ArrayDeque<>();
        TreeMap<Integer, Integer> posTreeMap = new TreeMap<>();

        Pattern tagPattern = Pattern.compile("(<" + tag + ")|(</" + tag + ">)");
        Matcher tagMatcher = tagPattern.matcher(htmlFile);

        while (tagMatcher.find()) {
            if (("<" + tag).equals(tagMatcher.group())) {
                startArrayDeque.push(tagMatcher.start());
            }

            if (("</" + tag + ">").equals(tagMatcher.group())) {
                posTreeMap.put(startArrayDeque.pop(), tagMatcher.end());
            }
        }

        for (Map.Entry<Integer, Integer> tagString: posTreeMap.entrySet()) {
            stringArrayList.add(htmlFile.substring(tagString.getKey(), tagString.getValue()));
        }

        return stringArrayList;
    }
}