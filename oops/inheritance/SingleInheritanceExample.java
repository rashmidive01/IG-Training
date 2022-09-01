package com.oops.inheritance;
class Student_Details
{
    public void showName()
    {
        System.out.println("My name is Khan");
    }
}
public class SingleInheritanceExample extends Student_Details{
    public static void main(String[] args) {
        Student_Details sd=new Student_Details();
        sd.showName();
    }

}
