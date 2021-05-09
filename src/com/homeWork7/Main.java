package com.homeWork7;
/*
 * Я специально создал MyIntegerCT и MyIntegerC, чтоб посмотреть как будет работать compareTo и Comparator по отдельности.
 * На уроке показывалась их работа в одном классе
 * MyIntegerCT - использует для сортировки compareTo
 * MyIntegerC - использует для сортировки Comparator
 */

import com.homeWork7.task1.CountPrimeNumComparator;
import com.homeWork7.task1.MyIntegerC1;
import com.homeWork7.task1.MyIntegerCT1;
import com.homeWork7.task2.CountDigitsInDecimalRepresentation;
import com.homeWork7.task2.MyIntegerC2;
import com.homeWork7.task2.MyIntegerCT2;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("Task1");
        System.out.println("Создать класс целых чисел MyInteger с порядком на основе количества простых делителей.");
        System.out.print("\nMyInteger using compareTo\n");
        MyIntegerCT1 oneCT1 = new MyIntegerCT1(210);
        MyIntegerCT1 oneCT2 = new MyIntegerCT1(30);
        MyIntegerCT1 oneCT3 = new MyIntegerCT1(6);
        MyIntegerCT1 oneCT4 = new MyIntegerCT1(2);
        MyIntegerCT1 oneCT5 = new MyIntegerCT1(0);

        TreeSet<MyIntegerCT1> oneCTs = new TreeSet<>();
        oneCTs.add(oneCT1);
        oneCTs.add(oneCT2);
        oneCTs.add(oneCT3);
        oneCTs.add(oneCT4);
        oneCTs.add(oneCT5);
        oneCTs.forEach(System.out::println);

        System.out.println("\nMyInteger using Comparator");
        MyIntegerC1 oneC1 = new MyIntegerC1(210);
        MyIntegerC1 oneC2 = new MyIntegerC1(30);
        MyIntegerC1 oneC3 = new MyIntegerC1(6);
        MyIntegerC1 oneC4 = new MyIntegerC1(2);
        MyIntegerC1 oneC5 = new MyIntegerC1(0);
        TreeSet<MyIntegerC1> oneCs = new TreeSet<>(new CountPrimeNumComparator());
        oneCs.add(oneC1);
        oneCs.add(oneC2);
        oneCs.add(oneC3);
        oneCs.add(oneC4);
        oneCs.add(oneC5);
        oneCs.forEach(System.out::println);
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("Task2");
        System.out.println("Создать класс целых чисел MyInteger с порядком на основе количества различных (!) цифр в десятичном представлении.");
        System.out.println("\nMyInteger using compareTo");
        MyIntegerCT2 oneCT21 = new MyIntegerCT2(123456789);
        MyIntegerCT2 oneCT22 = new MyIntegerCT2(111222333);
        MyIntegerCT2 oneCT23 = new MyIntegerCT2(111);
        MyIntegerCT2 oneCT24 = new MyIntegerCT2(10);
        MyIntegerCT2 oneCT25 = new MyIntegerCT2(5);

        TreeSet<MyIntegerCT2> oneCT2s = new TreeSet<>();
        oneCT2s.add(oneCT21);
        oneCT2s.add(oneCT22);
        oneCT2s.add(oneCT23);
        oneCT2s.add(oneCT24);
        oneCT2s.add(oneCT25);
        oneCT2s.forEach(System.out::println);

        System.out.println("\nMyInteger using Comparator");
        MyIntegerC2 oneC21 = new MyIntegerC2(123456789);
        MyIntegerC2 oneC22 = new MyIntegerC2(111222333);
        MyIntegerC2 oneC23 = new MyIntegerC2(111234);
        MyIntegerC2 oneC24 = new MyIntegerC2(10);
        MyIntegerC2 oneC25 = new MyIntegerC2(5);
        TreeSet<MyIntegerC2> oneC2s = new TreeSet<>(new CountDigitsInDecimalRepresentation());
        oneC2s.add(oneC21);
        oneC2s.add(oneC22);
        oneC2s.add(oneC23);
        oneC2s.add(oneC24);
        oneC2s.add(oneC25);
        oneC2s.forEach(System.out::println);
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
    }
}


