package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static void main(String[] args )throws Exception {
        List<Horse> horses= new ArrayList<Horse>();
        Horse horse1=new Horse("Васька",3, 0);
        Horse horse2=new Horse("Петька",3,0);
        Horse horse3=new Horse("Аленка",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
        



    }

    public void run() throws InterruptedException {
        for (int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(200);

        }

    }
    public void move(){
        for (Horse horse:horses){
            horse.move();
        }

    }
    public void print(){
        for(Horse horse:horses) {
            horse.print();
        }
            for(int i=0; i<10;i++){
                System.out.println();
        }

    }

    public Horse getWinner(){
        Horse winner=horses.get(0);
        double dist=horses.get(0).getDistance();
        for (Horse horse:horses)
            if(horse.getDistance()>dist){

                dist=horse.getDistance();
                winner =horse;


        }

        return winner;
    }
    public void printWinner(){

        System.out.println("Winner is " + getWinner().getName() + "!");

    }


    public static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
   public List<Horse> getHorses() {
        return this.horses;
    }
}
