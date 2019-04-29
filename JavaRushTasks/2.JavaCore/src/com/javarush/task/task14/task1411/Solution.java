package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        //ArrayList<String> list = new ArrayList<String>();
        String[] arr = { "user", "loser", "coder", "proger" };
        Set<String> set = new HashSet<>(Arrays.asList(arr));

        while(true){
            key = reader.readLine();
            if(!set.contains(key)) break;
            if (key.equals("user")) doWork(new Person.User());
            else if (key.equals("loser")) doWork(new Person.Loser());
            else if (key.equals("coder")) doWork(new Person.Coder());
            else if (key.equals("proger")) doWork(new Person.Proger());
        }
    }

    public static void doWork(Person person) {
        if(person instanceof Person.User) ((Person.User) person).live();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        else if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();

    }
}