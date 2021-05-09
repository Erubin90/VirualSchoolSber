

package com.homeWork7.task1;
import org.jetbrains.annotations.NotNull;

public class MyIntegerCT1 implements Comparable<MyIntegerCT1>{
    int number;

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
                i = 2;
            }
        }
        return count;
    }

    @Override
    public int compareTo(@NotNull MyIntegerCT1 o) {
        return Integer.compare(setCountPrimeNum(this.number), setCountPrimeNum(o.number));
    }

    @Override
    public String toString() {
        return "MyIntegerCT1{" +
                "num = " + number +
                '}';
    }
}


