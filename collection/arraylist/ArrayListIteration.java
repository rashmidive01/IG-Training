package com.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListIteration {
    public static void main(String[] args) {
        List<String> tvserials = new ArrayList<>();
        tvserials.add("Breaking Bad");
        tvserials.add("Game Of Thrones");
        tvserials.add("Friends");
        tvserials.add("Prison break");

        System.out.println("=== Iterate using Java 8 forEach and lambda ===");
        tvserials.forEach(serial -> {
            System.out.println(serial);
        });

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> serialsIterator = tvserials.iterator();
        while (serialsIterator.hasNext()) {
            String serial = serialsIterator.next();
            System.out.println(serial);
        }

        System.out.println("\n=== Iterate using an iterator() and Java 8 forEachRemaining() method ===");
        serialsIterator = tvserials.iterator();
        serialsIterator.forEachRemaining(serial -> {
            System.out.println(serial);
        });

        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        // Here, we start from the end of the list and traverse backwards.
        ListIterator<String> tvSerialListIterator = tvserials.listIterator(tvserials.size());
        while (tvSerialListIterator.hasPrevious()) {
            String tvShow = tvSerialListIterator.previous();
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for(String tvSerial : tvserials) {
            System.out.println(tvSerial);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for(int i = 0; i < tvserials.size(); i++) {
            System.out.println(tvserials.get(i));
        }
    }
}
