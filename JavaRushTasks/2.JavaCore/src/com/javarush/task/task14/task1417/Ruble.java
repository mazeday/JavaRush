package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    public Ruble(double amount) {
        super(amount);

    }


    public double getAmount(){
        return 4.0D;
    }

    public String getCurrencyName(){
        return "RUB";

    }
}
