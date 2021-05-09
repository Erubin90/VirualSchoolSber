package com.homeWork7;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class MyIntegerFirst implements Comparable<MyIntegerFirst>{
    int num;
    int countPrimeNum;

    public MyIntegerFirst(int num) {
        this.num = num;
        countPrimeNum = setCountPrimeNum(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int setCountPrimeNum(int x) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(x); i++, count++) {
            if (x % i == 0) {
                return count;
            }
        }
        return count;
    }

    @Override
    public int compareTo(@NotNull MyIntegerFirst o) {
        return Integer.compare(this.countPrimeNum, o.countPrimeNum);
    }

    @Override
    public String toString() {
        return "MyIntegerFirst{" +
                "num = " + num +
                ", countPrimeNum = " + countPrimeNum +
                '}';
    }
}

class CountPrimeNumComparator implements Comparator<MyIntegerFirst> {

    @Override
    public int compare(MyIntegerFirst o1, MyIntegerFirst o2) {
        int countO1 = countPrimeNum(o1);
        int countO2 = countPrimeNum(o2);
        return Integer.compare(countO1, countO2);
    }

    private int countPrimeNum (MyIntegerFirst x) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(x.getNum()); i++, count++) {
            if (x.getNum() % i == 0) {
                return count;
            }
        }
        return count;
    }
}


