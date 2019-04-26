package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null){throw new TooShortStringException();};

        int a=string.indexOf("\t");
        int b;
        if( string.indexOf("\t",a+1)==-1){
            throw new TooShortStringException();
        }else {
            b = string.indexOf("\t", a + 1);
        }
        string=string.substring(a+1,b);

        return string;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
