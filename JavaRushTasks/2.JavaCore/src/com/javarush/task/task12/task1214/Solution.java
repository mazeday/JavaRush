package com.javarush.task.task12.task1214;

/* 
Корова — тоже животное
*/

public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Animal {
        public abstract String getName();

    }

    public  static class Cow extends Animal  {
        public  String getName() {
            return "sa";
        }
    }

}
