package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int a=number/100;
        int b= number-a*100;
        int c = b/10;
        int d=b-c*10;


        return a+c+d;
    }
}