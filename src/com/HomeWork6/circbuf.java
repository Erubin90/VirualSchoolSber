package com.HomeWork6;

import java.util.*;

public class circbuf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeDeque = 4;
        ArrayDeque<Integer> deque = new ArrayDeque<>(4);
        List<String> operation;
        int count = scan.nextInt();
        String str;
        while (count >= 0) {
            str = scan.nextLine().toUpperCase();
            operation = new ArrayList<>(Arrays.asList(str.split("\\s")));
            if(operation.size() == 1) {
                if ("DEQ".equals(operation.get(0))) {
                    System.out.println(deque.removeFirst());
                }
                else if ("EMPTY".equals(operation.get(0))) {
                    if (deque.size() == sizeDeque) {
                        // тут должно быть расшиерние очерди, но так как у нас очередь раширяемая то я не знаю что делать
                    }
                    System.out.println(deque.isEmpty());
                }
            }
            else if (operation.size() == 2){
                deque.addLast(Integer.parseInt(operation.get(1)));
                System.out.println(operation.get(1));

            }
            operation.clear();
            count--;
        }
    }
}
