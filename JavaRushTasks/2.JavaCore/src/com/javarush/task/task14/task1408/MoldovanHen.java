package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    int egg=19;
    public int getCountOfEggsPerMonth(){
        return egg;
    }
    public String getDescription(){
        return super.getDescription()+" Моя страна - "+MOLDOVA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
