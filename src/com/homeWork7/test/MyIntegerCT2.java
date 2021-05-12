

package com.homeWork7.test;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class MyIntegerCT2 implements Comparable<MyIntegerCT2>{
    private Integer number;

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
        Integer x = countDigitsInDecimalRepresentation(this.number);
        Integer y = countDigitsInDecimalRepresentation(o.number);
        if (this.number.equals(o.number)) {
            return 0;
        }
        else {
            if (x.equals(y)) {
                return this.number < o.number ? -1 : 1;
            }
            else {
                return x < y ? -1 : 1;
            }
        }
    }

    @Override
    public String toString() {
        return "MyIntegerCT2{" +
                "num = " + number +
                '}';
    }
}


