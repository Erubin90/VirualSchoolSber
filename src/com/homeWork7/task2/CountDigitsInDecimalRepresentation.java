package com.homeWork7.task2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CountDigitsInDecimalRepresentation implements Comparator<MyIntegerC2> {

    @Override
    public int compare(MyIntegerC2 o1, MyIntegerC2 o2) {
        int countO1 = countDigitsInDecimalRepresentation(o1.getNumber());
        int countO2 = countDigitsInDecimalRepresentation(o2.getNumber());
        return Integer.compare(countO1, countO2);
    }

    private int countDigitsInDecimalRepresentation(int num) {
        Set<Integer> count = new HashSet<>();
        while (num > 9) {
            count.add(num % 10 );
            num /= 10;
        }
        count.add(num % 10);
        return count.size();
    }
}
