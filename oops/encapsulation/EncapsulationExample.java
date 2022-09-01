package com.oops.encapsulation;
class Employee1 {

    private String Name;

    private int EmpID;

    private int Age;

    public int getAge() {

        return Age;

    }

    public String getName() {

        return Name;

    }

    public int getEmpID() {

        return EmpID;

    }

    public void setAge(int newAge) {

        Age = newAge;

    }

    public void setName(String newName) {

        Name = newName;

    }

    public void setRoll(int newEmpID) {

        EmpID = newEmpID;

    }

    public void setEmpID(int EmpID) {

    }

}
public class EncapsulationExample {
    public static void main (String[] args)

    {

        Employee1 e = new Employee1();

        e.setName("Robert");

        e.setAge(33);

        e.setEmpID(1253);

        System.out.println("Employee's name: " + e.getName());

        System.out.println("Employee's age: " + e.getAge());

        System.out.println("Employee's ID: " + e.getEmpID());

    }
}
