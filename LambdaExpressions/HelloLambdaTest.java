package com.LambdaExpressions;

public class HelloLambdaTest {
    public static void main(String[] args) {

        HelloLambda helloLambda= () -> {System.out.println("Hello world");};
        helloLambda.sayHello();
    }
}
