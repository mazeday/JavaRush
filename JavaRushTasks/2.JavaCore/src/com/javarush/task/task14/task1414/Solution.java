package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task14.task1414.Solution.MovieFactory.getMovie;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        Movie movie = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        String[] arr = { "soapOpera", "cartoon", "thriller"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        while (true){
            key = reader.readLine();
            movie=MovieFactory.getMovie(key);
            if (!set.contains(key))break;
            System.out.println(movie.getClass().getSimpleName());


        }


        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */



    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie  {
    }
    static class Thriller extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
}
