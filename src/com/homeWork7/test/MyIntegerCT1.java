

package com.homeWork7.test;
import org.jetbrains.annotations.NotNull;

public class MyIntegerCT1 implements Comparable<MyIntegerCT1>{
    private Integer number;

    public MyIntegerCT1(int num) {
        this.number = num;
    }

    private int setCountPrimeNum(int x) {
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

    @Override
    public int compareTo(@NotNull MyIntegerCT1 o) {
        Integer x = setCountPrimeNum(this.number);
        Integer y = setCountPrimeNum(o.number);
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
        return "MyIntegerCT1{" +
                "num = " + number +
                '}';
    }
}


