package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    public String name;
    private boolean busy;
    private boolean stopped = false;
    private boolean caught = false;
   // private StatisticManager statisticManager = StatisticManager.getInstance();
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }



    public void startCookingOrder(Order order){
        busy = true;

        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                order.toString(),
                this.name,
                order.getTotalCookingTime()*60,
                order.getDishes()));


        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
        }
        setChanged();
        notifyObservers(order);
        busy = false;

    }


    public void run() {
        while (!stopped) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (queue.peek() != null) {

                if (!this.isBusy()) {
                    try {
                        //final Cook cookFinal = cook;
                        Order order = queue.take();
                        if (order != null) {
                            //Thread tr = new Thread(()->
                            startCookingOrder(order);
                            //tr.start();
                        }
                    } catch (InterruptedException e) {
                        caught = true;
                    }
                }
            }
            if (caught && queue.isEmpty()) stopped = true;
        }
    }
}
