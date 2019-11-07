package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        /*
        Tablet tablet = new Tablet(5);
        Cook firstCook = new Cook("Amigo");
        Waiter firstWaiter = new Waiter();
        tablet.addObserver(firstCook);
        firstCook.addObserver(firstWaiter);

        for (int i = 0; i < 4; i++) {
            tablet.createOrder();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
*/
/*
        Locale.setDefault(Locale.ENGLISH);

        Waiter waiter = new Waiter();

        OrderManager orderManager = new OrderManager();

        List<Cook> cookList = new LinkedList<>();
        for (int i =1; i<3; i++) {
            Cook cook = new Cook("Amigo"+i);
            StatisticManager.getInstance().register(cook);
            cook.addObserver(waiter);
            cookList.add(cook);
        }

        List<Tablet> tabletList = new LinkedList<>();
        for(int i=1; i<6; i++) {
            Tablet tablet = new Tablet(i);
            for(Cook cook : cookList) tablet.addObserver(orderManager);
            tabletList.add(tablet);

        }

        DirectorTablet directorTablet= new DirectorTablet();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList,ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            return;
        }
        thread.interrupt();

        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
*/

        Cook cook1 = new Cook("Bobrov");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Bilbao");
        cook2.setQueue(orderQueue);
        Thread cooker1 = new Thread(cook1);
        Thread cooker2 = new Thread(cook2);
        cooker1.start();
        cooker2.start();

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }

        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tabletList,ORDER_CREATING_INTERVAL);
        Thread testTask = new Thread(generatorTask);
        testTask.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        testTask.interrupt();

        /*try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }*/

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
