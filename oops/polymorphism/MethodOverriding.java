package com.oops.polymorphism;

class Animal {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}

class Dog extends Animal {
    @Override
    public void displayInfo() {
        System.out.println("I am a dog.");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.displayInfo();
    }
}