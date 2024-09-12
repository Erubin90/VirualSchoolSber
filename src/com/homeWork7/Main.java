package com.homeWork7;
import com.homeWork7.test.MyIntegerCT1;
import com.homeWork7.test.MyIntegerCT2;

/*
 * Я специально создал MyIntegerCT и MyIntegerC, чтоб посмотреть как будет работать compareTo и Comparator по отдельности.
 * На уроке показывалась их работа в одном классе
 * MyIntegerCT - использует для сортировки compareTo
 * MyIntegerC - использует для сортировки Comparator
 */

import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Integer[] testTask1 = {64, 65, 63, 70, 8};
        Integer[] testTask2 = {123456789, 1111, 111, 10, 50};
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("Task1");
        System.out.println("Создать класс целых чисел MyInteger с порядком на основе количества простых делителей.");
        System.out.println("Числа для теста: " + Arrays.toString(testTask1));
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("MyInteger using compareTo");
        MyIntegerCT1[] one = new MyIntegerCT1[testTask1.length];
        for (int i = 0; i < one.length; i++){
            one[i] = new MyIntegerCT1(testTask1[i]);
        }
        TreeSet<MyIntegerCT1> oneCT = new TreeSet<>(Arrays.asList(one));
        oneCT.forEach(System.out::println);

        System.out.println("\nMyInteger using CountPrimeNumComparator");
        MyInteger[] myIntegers1 = new MyInteger[testTask1.length];
        for (int i = 0; i < myIntegers1.length; i++) {
            myIntegers1[i] = new MyInteger(testTask1[i]);
        }
        TreeSet<MyInteger> oneCs = new TreeSet<>(new CountPrimeNumComparator());
        oneCs.addAll(Arrays.asList(myIntegers1));
        oneCs.forEach(System.out::println);

        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("Task2");
        System.out.println("Создать класс целых чисел MyInteger с порядком на основе количества различных (!) цифр в десятичном представлении.");
        System.out.println("Числа для теста: " + Arrays.toString(testTask2));
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("MyInteger using compareTo");
        MyIntegerCT2[] twoCT = new MyIntegerCT2[testTask2.length];
        for (int i = 0; i < twoCT.length; i++) {
            twoCT[i] = new MyIntegerCT2(testTask2[i]);
        }

        TreeSet<MyIntegerCT2> twoCTs = new TreeSet<>(Arrays.asList(twoCT));
        twoCTs.forEach(System.out::println);

        System.out.println("\nMyInteger using CountDigitsInDecimalRepresentation");
        MyInteger[] myIntegers2 = new MyInteger[testTask2.length];
        for (int i = 0; i < myIntegers2.length; i++) {
            myIntegers2[i] = new MyInteger(testTask2[i]);
        }
        TreeSet<MyInteger> two = new TreeSet<>(new CountDigitsInDecimalRepresentation());
        two.addAll(Arrays.asList(myIntegers2));
        two.forEach(System.out::println);
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
    }
}


