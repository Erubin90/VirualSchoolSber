package com.HomeWork9_FP.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamImplementation {

    public static <T, R> List<R> map(List<T> origin, Function<T, R> mapper) {
        if(!origin.isEmpty()) {
            List<R> result;
            if (origin instanceof ArrayList) {
                result = new ArrayList<>();
            } else {
                result = new LinkedList<>();
            }
            for (T element : origin) {
                result.add(mapper.apply(element));
            }
            return result;
        }
        else {
            return null;
        }


    }

    public static <T> void forEach(List<T> origin, Consumer<T> consumer) {
        for (T element : origin) {
            consumer.accept(element);
        }
    }

    public static <T> List<T> filter(List<T> origin, Predicate<T> predicate) {
        if (!origin.isEmpty()) {
            List<T> result;
            if (origin instanceof ArrayList) {
                result = new ArrayList<>();
            } else {
                result = new LinkedList<>();
            }
            for (T element : origin) {
                if (predicate.test(element)) {
                    result.add(element);
                }
            }
            return result;
        }
        else {
            return origin;
        }
    }

    public static <T> T reduce(List<T> origin, BinaryOperator<T> binaryOperator) {
        if (origin.size() >= 2) {
            T result = origin.get(0);
            for (int i = 1; i < origin.size(); i++) {
                result = binaryOperator.apply(result, origin.get(i));
            }
            return result;
        }
        else {
            if (origin.size() == 1) {
                return origin.get(0);
            }
            else {
                return null;
            }
        }
    }

    public static <T> Integer sum(List<T> origin) {
        var sum = 0;
        for (var element : origin) {
            sum += (int) element;
        }
        return sum;
    }

    public static <T> int count(List<T> origin, Predicate<T> predicate) {
        int count = 0;
        for (T element : origin) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }
}
