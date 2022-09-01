package com.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> employee = new ArrayList<>();
        System.out.println("Is the employee list is empty");
        if (employee.isEmpty())
        {
            System.out.println("The employee list is empty");
        }
        else
        {
            System.out.println("The employee list contain elements");
        }
        employee.add("Sagar");
        employee.add("Gayatri");
        employee.add("Rashmi");
        employee.add("Anaya");
        employee.add("Vedant");
        employee.add("Aarohi");

        System.out.println("The size of list: "+employee.size());
        System.out.println("The list of employees : " +employee);

        String firstEmployee = employee.get(0);
        String lastEmployee = employee.get(employee.size()-1);
        String midEmployee = employee.get(employee.size()/2);

        System.out.println("The first employee in the list " +firstEmployee);
        System.out.println("The last employee in the list " +lastEmployee);
        System.out.println("The mis employee in the list " +midEmployee);



    }
}
