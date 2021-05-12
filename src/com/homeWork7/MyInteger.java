
package com.homeWork7;

public class MyInteger {
    private Integer number;

    public MyInteger(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "number=" + number +
                '}';

    }
}

