package com.oops.abstraction;
interface Address
{
    public void getAddress();
}
interface Details
{
    public void getName();
    public void getDesignation();

}
class Employee implements Details,Address
{

    @Override public void getAddress()
    {
        System.out.println("The address is nagpur");
    }
    @Override public void getName()
    {
        System.out.println("The name is RAM");
    }

    @Override
    public void getDesignation() {
        System.out.println("The designation is Software engineer");
    }


}

public class AbstractionInterfaceExample extends Employee {
    public static void main(String[] args) {
        Employee emp=new Employee();
        emp.getAddress();
        emp.getName();
        emp.getDesignation();
    }
}
