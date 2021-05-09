package com.homeWork7.task1;

import java.util.Comparator;

public class CountPrimeNumComparator implements Comparator<MyIntegerC1> {

    @Override
    public int compare(MyIntegerC1 o1, MyIntegerC1 o2) {
        int o1Count = countPrimeNum(o1.getNumber());
        int o2Count = countPrimeNum(o2.getNumber());
        return Integer.compare(o1Count, o2Count);

    }

    private int countPrimeNum (int x) {
        int count = 0;
        for (int i = 2; i <= x; i++) {
            if (x % i == 0) {
                count++;
                x /= i;
                i = 2;
            }
        }
        return count;
    }
}
