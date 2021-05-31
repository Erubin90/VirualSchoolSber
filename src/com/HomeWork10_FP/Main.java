package com.HomeWork10_FP;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Task1
        System.out.println("Task1");
        Set<Integer> set = Stream.generate(() -> new Random().nextInt(2000) - 1000)
                .filter(x -> x % 2 == 0 && x > 0)
                .map((x) -> x * 2)
                .peek((x) -> System.out.print(x + " "))
                .limit(15)
                .collect(Collectors.toSet());
        int sum = set.stream().reduce(0,Integer::sum);
        System.out.println();
        System.out.println(sum);
        //Task 2_1
        System.out.println("Task 2_1");
        List<String> list1 = new ArrayList<>(Arrays.asList("Andrey", "Sergey", "Georgy", "Alexey"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Amin", "Vitaly", "Andrey", "Victoria"));
        List<String> list3 = new ArrayList<>(Arrays.asList("Sergey", "Vladimir", "Georgy", "Amina"));
        List<String> list4 = new ArrayList<>(Arrays.asList("Alexander", "Vitaly", "Ekaterina", "Alexey"));
        Set<String> names = Stream.concat(Stream.concat(list1.stream(), list2.stream()), Stream.concat(list3.stream(), list4.stream()))
                .collect(Collectors.toSet());
        System.out.println(names);
        //Task 2_2
        System.out.println("Task 2_2");
        Map<String, Double> items = new HashMap<>();
        items.put("Andrey", 65.4);
        items.put("Vitaly", 73.6);
        items.put("Ekaterina", 55.1);
        long count = items.values().size();
        Double avg = items.values().stream()
                .reduce(0d,(x, y) -> x + y / count);
        System.out.println(avg);
        //Task 2_3
        System.out.println("Task 2_3");
        List<Long> longList1 = new ArrayList<>(Arrays.asList(1L, 4L, 5L, 2L, 5L, 6L));
        List<Long> longList2 = new ArrayList<>(Arrays.asList(5L, 7L, 6L, 7L, 8L, 9L));
        List<Long> list = Stream.concat(new HashSet<>(longList1).stream(), new HashSet<>(longList2).stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry:: getKey)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
