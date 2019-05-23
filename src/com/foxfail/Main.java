package com.foxfail;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        int number = myClass.getNumber();
        String name = null; // а геттера name нету =(

        System.out.println("number: " + number);
        System.out.println("name: " + name);

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

        System.out.println("number: " + number);
        System.out.println("name: " + name);

    }
}
