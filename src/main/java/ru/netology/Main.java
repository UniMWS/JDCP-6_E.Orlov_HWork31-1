package ru.netology;

public class Main {
    public static void main(String[] args) {
        System.out.println("JDCP-6, Евгений Орлов, ДЗ-31: " +
                "\"Порождающие шаблоны. Builder, Singleton, Factory Method, Abstract Factory, Prototype\"");
        System.out.println("Задача 1.\n");

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}