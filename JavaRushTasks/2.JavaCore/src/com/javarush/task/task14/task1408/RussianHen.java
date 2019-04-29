package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{
    int egg=26;
    public int getCountOfEggsPerMonth(){
        return egg;
    }
    public String getDescription(){
        return super.getDescription()+" Моя страна - "+RUSSIA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
