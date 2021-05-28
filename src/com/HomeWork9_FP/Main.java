package com.HomeWork9_FP;

import com.HomeWork9_FP.task1.Swimmer;
import com.HomeWork9_FP.task2.QuadFunction;
import com.HomeWork9_FP.task2.TriFunction;
import com.HomeWork9_FP.task3.StreamImplementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Task 1
        Swimmer swimmer = new Swimmer("Ivan", 25);
        System.out.println("Стартовое имя и возраст - " + String.join(", ",
                swimmer.getName(), swimmer.getAge().toString()));
        System.out.print("Вывод имени при помощи swim - ");
        swimmer.swim(System.out::println);
        Supplier<String> supplier = swimmer::getName;
        System.out.println("Вывод имени при помощи Supplier - " + supplier.get());
        BiConsumer<String, Integer> setNameAndAge = (name, age) -> {swimmer.setName(name); swimmer.setAge(age);};
        setNameAndAge.accept("Amin", 24);
        System.out.println("Замена имени и возраста при помощи BiConsumer - " + String.join(", ",
                swimmer.getName(), swimmer.getAge().toString()));
        //Task 2
        TriFunction<Boolean, String, Integer, String> triFunction = (bool, name, age) -> {
            if (bool) {
                setNameAndAge.accept(name, age);
                return "Данные пользователя обнавленны";
            }
            else {
                return "Такой пользователь не найден";
            }
        };
        QuadFunction<Integer, Integer, Integer, Integer, Boolean> quadFunction = (num1, num2, num3, num4) ->
                num1 + num2 + num3 + num4 > 20;
        //Task 3
        List<Integer> arr = new LinkedList<>(Arrays.asList(1, 21, 10, 4));
        System.out.println(StreamImplementation.map(arr, (x) -> x + 10));
        StreamImplementation.forEach(arr, System.out::println);
        System.out.println(StreamImplementation.filter(arr, (x) -> x <= 10));
        System.out.println(StreamImplementation.reduce(arr, (x, y) -> y += x));
        System.out.println(StreamImplementation.count(arr, (x) -> x <= 10));
    }
}
