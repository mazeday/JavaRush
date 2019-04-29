package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface TableInterface;

        public TableInterfaceWrapper(TableInterface TableInterface) {
            this.TableInterface = TableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            TableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return TableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            TableInterface.setHeaderText(newHeaderText);
        }

    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}