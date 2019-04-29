package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        Integer a = array.get(0);
        for (int i=1; i<array.size();i++){
            if( array.get(i)<a){
                a=array.get(i);


            }

        }
        return a;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        ArrayList<Integer> list= new ArrayList<Integer>();

        for (int i=0; i<n; i++) {
            String sAge = reader.readLine();
            list.add((Integer.parseInt(sAge)));
        }
        return list;
    }
}
