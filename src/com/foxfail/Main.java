package com.foxfail;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        /*
         * Реализован класс MyClass с приватными полями number и name
         * реализован геттер getNumber
         * однако getName отсутвует.
         * Поэтому используем рефлексию что бы получить доступ к полю и установить в него значение
         */

        MyClass myClass = new MyClass();
        int number = myClass.getNumber();
        String name = null; // а геттера name нету =(

        System.out.println("number: " + number); // number: 0
        System.out.println("name: " + name); // name: null

        try {
            System.out.println("Происходит магия рефлексии!!!");
            Field field = myClass.getClass().getDeclaredField("name"); // получаем поле из класса
            field.setAccessible(true); // распривачиваем поле
            name = (String) field.get(myClass); // получаем значение
            field.setAccessible(false); // заприватим обратно на всякий случай
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Фокус не удался =(");
            e.printStackTrace();
        }

        System.out.println("number: " + number); // number: 0
        System.out.println("name: " + name); // name: myName

    }
}
