package com.HomeWork9_FP.task1;

import java.util.function.Consumer;

public class Swimmer {
    private String  name;
    private Integer age;

    public Swimmer() {
    }

    public Swimmer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void swim(Consumer<String> c) {
        c.accept(name);
    }

}
