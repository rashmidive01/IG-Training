package com.oops.abstraction;

interface College {
    void collegeName();
    void getBranch();
    void getID();
}

abstract class Student1 implements College {

    @Override public void collegeName()
    {
        System.out.println("College Name is Raisoni");
    }
    @Override public void getID()
    {
        System.out.println("ID is 21054");
    }
}

class branch extends Student1 {
    @Override public void getBranch()
    {
        System.out.println("Branch is IT");
    }
}

public class AbstractionUsingInterface {
    public static void main(String[] args)
    {
        branch b = new branch();
        b.collegeName();
        b.getBranch();
        b.getID();
    }
}



