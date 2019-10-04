package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    public int id;
    protected int age;
    protected String name;
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    protected Size size;

    public class Size {
        public int height;
        public int weight;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {

        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }



    //public static final int FIRST = 1;
    // public static final int SECOND = 2;
    // public static final int THIRD = 3;
    // public static final int FOURTH = 4;


    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild (Human human){
        children.add(human);
    }

    public void removeChild (Human human){
        children.remove(human);
    }




    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Human(String name, int age) {

        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }



    public int getId() {
        return id;
    }



    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }
}