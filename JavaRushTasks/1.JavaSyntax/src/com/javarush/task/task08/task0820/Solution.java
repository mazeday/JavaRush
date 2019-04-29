package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();


        Cat cat1=new Cat();
        result.add(cat1);
        Cat cat2=new Cat();
        result.add(cat2);
        Cat cat3=new Cat();
        result.add(cat3);
        Cat cat4=new Cat();
        result.add(cat4);



        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogs = new HashSet<Dog>();
        Dog dog1=new Dog();
        dogs.add(dog1);
        Dog dog2=new Dog();
        dogs.add(dog2);
        Dog dog3=new Dog();
        dogs.add(dog3);
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> animals = new HashSet<>();

            animals.addAll(cats);
            animals.addAll(dogs);



        return animals;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Object> iterator = pets.iterator();
        pets.removeAll(cats);

    }

    public static void printPets(Set<Object> pets) {

        for (Object c : pets){
            System.out.println(c);
        }

    }

    public static class Cat {

    }
    public static class Dog {

    }
}
