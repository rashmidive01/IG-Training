package com.LambdaExpressions;

public class AddDemoTest {
    public static void main(String[] args) {
        AddDemo ad=(int a,int b) -> {
        return (a+b);

    };

System.out.println(ad.sum(10,20));
}
}