package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1name = br.readLine();
        String f2name = br.readLine();
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader(f1name));
        BufferedReader br2 = new BufferedReader(new FileReader(f2name));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while(br1.ready())
        {
            list1.add(br1.readLine());
        }

        while(br2.ready())
        {
            list2.add(br2.readLine());
        }

        br1.close();
        br2.close();

        int f1count = 0;
        int f2count = 0;
        String f11 = "";
        String f21 = "";
        String t1 = "";
        String t2 = "";

        while (f1count < list1.size() && f2count < list2.size())
        {
            f11 = list1.get(f1count);
            f21 = list2.get(f2count);
            if (f11.equals(f21))
            {
                lines.add(new LineItem(Type.SAME, f11));
                f1count++;
                f2count++;
                if (f1count == list1.size() && f2count != list2.size())
                    lines.add(new LineItem(Type.ADDED, list2.get(f2count)));
                if (f1count != list1.size() && f2count == list2.size())
                    lines.add(new LineItem(Type.REMOVED, list1.get(f1count)));
            }
            else
            {
                if (f1count < list1.size()-1 && f2count < list2.size()-1)
                {
                    t1 = list1.get(f1count+1);
                    t2 = list2.get(f2count+1);
                    if (f11.equals(t2))
                    {
                        lines.add(new LineItem(Type.ADDED,f21));
                        f2count++;
                    }
                    else if (f21.equals(t1))
                    {
                        lines.add(new LineItem(Type.REMOVED, f11));
                        f1count++;
                    }
                }
                else if (f1count < list1.size() && f2count == list2.size())
                {
                    lines.add(new LineItem(Type.REMOVED, f11));
                    lines.add(new LineItem(Type.SAME,f21));
                    f1count += 2;
                    f2count++;
                }
                else if (f1count == list1.size() && f2count < list2.size())
                {
                    lines.add(new LineItem(Type.ADDED, f21));
                    lines.add(new LineItem(Type.SAME, f11));
                    f1count++;
                    f2count+=2;
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
