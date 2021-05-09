package com.homeWork7;

import org.jetbrains.annotations.NotNull;

public class MyIntegerSecond implements Comparable<MyIntegerSecond> {

    Integer num;

    public MyIntegerSecond(Integer num) {
        this.num = num;

    }

    @Override
    public int compareTo(@NotNull MyIntegerSecond o) {
        return 0;
    }

    @Override
    public String toString() {
        return "MyIntegerSecond{" +
                "num=" + num +
                '}';
    }
}
