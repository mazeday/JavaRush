package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    int egg=2;
    public int getCountOfEggsPerMonth(){
        return egg;
    }
    public String getDescription(){
        return super.getDescription()+" Моя страна - "+UKRAINE+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
