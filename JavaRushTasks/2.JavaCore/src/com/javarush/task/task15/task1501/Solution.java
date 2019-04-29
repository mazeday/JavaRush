package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        void isMovable();
    }

    public interface Sellable {
        void getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes  implements Movable, Sellable,Discountable{
        public void isMovable(){

        }
        public void getAllowedAction(String name){

        }

        @Override
        public Object getAllowedAction() {
            return null;
        }
    }
}
