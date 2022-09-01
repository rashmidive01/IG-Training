package com.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemoveElements {
    public static void main(String[] args) {
        List<String> collegeName = new ArrayList<>();
        collegeName.add("Raisoni");
        collegeName.add("YCC");
        collegeName.add("Ambetkar");
        System.out.println("Orignal list" +collegeName);
        collegeName.remove(1);
        System.out.println("Updated list" +collegeName);
    }
}
