package com.HomeWork2;
import java.util.Scanner;
public class Fibsys {
    //
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        long num = in.nextLong();
        long num1 = num;
        while (num > 0) {
            //Эта функция будет повторяться пока num не станет числом фибоначи
            num = fibonacci(num1);
            num1 = num;
        }
    }

    public static long fibonacci(long num) {
        long x0 = 0;
        long x1 = 1;
        int i = 0;
        //Определение максимального числа фибоначи для заданного числа и его порядковый номер
        while (num >= x1) {
            i++;
            x0 += x1;
            if (num < x0) {
                break;
            }
            if (x1 + x0 < 0) {
                break;
            }
            i++;
            x1 += x0;
        }
        i--;
        //Намиеньшее число из x0 и х1 будет максимальным числом входящее в num
        //Вычитываем от num минимальное полученное число фибоначи
        num = x0 > x1 ? num - x1 : num - x0;
        //Определяем число в фибоначевской системе счисления
        //Если разница  равна 0, это означает что num и есть число фибоначи и следовательно
        //длина будет равна порядковому номеру числа фибоначи
        //начинаться будет с 1 а количество 0 будет рано порядковый номер - 1
        if (num == 0) {
            System.out.print("1");
            while (i > 1) {
                System.out.print("0");
                i--;
            }
            //Если разница больше 0, это означает что num больше числа фибоначи
            //длина будет равна порядковому номеру числа фибоначи
            //начинаться будет с 1 а количество 0 будет рано пока num не станет числом фибоначи
        } else {
            System.out.print("1");
            if (x0 > x1) {
                reversFibonacci(x1, x0, num);
            } else {
                reversFibonacci(x0, x1, num);
            }
        }
        return num;
    }


    public static void reversFibonacci(long numMin, long numMax, long num) {
        //Уменьшает порядковый номер числа фибоначи пока число фибоначи не станет
        //меньше num
        while (num < numMin) {
            numMax -= numMin;
            if (num < numMax) {
                System.out.print("0");
            }
            numMin -= numMax;
            if (num < numMin) {
                System.out.print("0");
            }
        }
    }
}