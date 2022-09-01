package com.oops.abstraction;
abstract class Student
{
    abstract void address();
    public void name()
    {
        System.out.println("Name is Shyam");
    }

}
class StudentDetails extends Student
{
    @Override
    void address() {
        System.out.println("Stays in Maharashtra");
    }
}
public class AbstractClassExample extends StudentDetails {
    public static void main(String[] args) {
        StudentDetails sd=new StudentDetails();
        sd.name();
        sd.address();
    }
}
