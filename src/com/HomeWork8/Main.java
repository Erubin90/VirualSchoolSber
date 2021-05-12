package com.HomeWork8;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1(123456789);
        Task2 task2 = new Task2();
        for (Integer i: task1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i: task2) {
            System.out.print(i + " ");
        }
    }
}
