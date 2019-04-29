package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Integer kolvo = 1;
        Integer kolvoBig=1;
        ArrayList <Integer> list =new ArrayList<>();



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++) {
            String sAge = reader.readLine();
            int nAge = Integer.parseInt(sAge);
            list.add(nAge);
        }

        for (int i=1; i<list.size();i++) {

            if (list.get(i).equals(list.get(i-1))){
                kolvo++;
                kolvoBig = kolvo > kolvoBig ? kolvo : kolvoBig;
            }
            else {
                kolvo=1;}

        }


        System.out.println(kolvoBig);
    }
}