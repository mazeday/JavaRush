package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.javarush.task.task24.task2409.Util.Company.Denim;
import static com.javarush.task.task24.task2409.Util.Company.Levis;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            abstract class AbstractJeans implements Jeans {

                @Override
                public int getId() {
                    return id;
                }

                @Override
                public int getLength() {
                    return length;
                }

                @Override
                public double getPrice() {
                    return price;
                }

                @Override
                public int getSize() {
                    return size;
                }

                public abstract String getTM();

                public AbstractJeans(int id, int length, int size, double price) {
                }

                @Override
                public String toString() {
                    return  getTM() + "{id=" + getId() + ", length=" + getLength() + ", size=" +
                            getSize() + ", price=" + getPrice() + "}";
                }
            }

            class Levis extends AbstractJeans {
                @Override
                public String getTM() {
                    return getClass().getSimpleName();
                }

                public Levis(int id, int length, int size, double price) {
                    super(id, length, size, price);
                }
            }

            class Denim extends AbstractJeans {
                @Override
                public String getTM() {
                    return getClass().getSimpleName();
                }

                public Denim(int id, int length, int size, double price) {
                    super(id, length, size, price);
                }
            }

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    public String getTM() {
                        return getClass().getSimpleName();
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        Company(String name) {
            this.fullName = name;
        }
    }
}