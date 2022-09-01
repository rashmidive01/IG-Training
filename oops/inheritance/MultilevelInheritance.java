package com.oops.inheritance;
class Car
{
    public void carName()
    {
        System.out.println("It's Amaze");
    }
}
class CarDetails extends Car {
    public void carModule()
    {
        System.out.println("It's topup model");
    }
}
public class MultilevelInheritance extends CarDetails {

    public static void main(String[] args) {
        CarDetails cd=new CarDetails();
        cd.carName();
        cd.carModule();
    }
}

