package com.homeWork7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CountDigitsInDecimalRepresentation implements Comparator<MyInteger> {

    @Override
    public int compare(MyInteger o1, MyInteger o2) {
        Integer x = countDigitsInDecimalRepresentation(o1.getNumber());
        Integer y = countDigitsInDecimalRepresentation(o2.getNumber());
        if (o1.getNumber().equals(o2.getNumber())) {
            return 0;
        }
        else {
            if (x.equals(y)) {
                return o1.getNumber() < o2.getNumber() ? -1 : 1;
            }
            else {
                return x < y ? -1 : 1;
            }
        }
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
