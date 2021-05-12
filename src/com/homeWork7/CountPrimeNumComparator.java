package com.homeWork7;

import java.util.Comparator;

public class CountPrimeNumComparator implements Comparator<MyInteger> {

    @Override
    public int compare(MyInteger o1, MyInteger o2) {
        Integer x = countPrimeNum(o1.getNumber());
        Integer y = countPrimeNum(o2.getNumber());
        if (o1.getNumber().equals(o2.getNumber())) {
            return 0;
        }
        else {
            if (x.equals(y)) {
                return o1.getNumber() < o2.getNumber() ? -1: 1;
            }
            else {
                return x < y ? -1 : 1;
            }
        }
    }

    private int countPrimeNum(int x) {
        int count = 0;
        if (x == 1) {
            return x;
        }
        for (int i = 2; i <= x; i++) {
            if (x % i == 0) {
                count++;
                x /= i;
                i = 1;
            }
        }
        return count;
    }
}
