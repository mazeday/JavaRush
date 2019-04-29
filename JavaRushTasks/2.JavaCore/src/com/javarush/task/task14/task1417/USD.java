package com.javarush.task.task14.task1417;

public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }


    public double getAmount() {
        return 506.0D;
    }

    public String getCurrencyName(){
        return "USD";

    }
}
