

package com.homeWork7.task2;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class MyIntegerCT2 implements Comparable<MyIntegerCT2>{
    int number;

    public MyIntegerCT2(int num) {
        this.number = num;
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

    @Override
    public int compareTo(@NotNull MyIntegerCT2 o) {
        int count1 = countDigitsInDecimalRepresentation(this.number);
        int count2 = countDigitsInDecimalRepresentation(o.number);
        return Integer.compare(count1, count2);
    }

    @Override
    public String toString() {
        return "MyIntegerCT2{" +
                "num = " + number +
                '}';
    }
}


