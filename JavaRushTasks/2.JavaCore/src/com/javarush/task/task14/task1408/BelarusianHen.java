package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{
    int egg=8;
    public int getCountOfEggsPerMonth(){
        return egg;
    }
    public String getDescription(){
       return super.getDescription()+" Моя страна - "+BELARUS+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }


}
