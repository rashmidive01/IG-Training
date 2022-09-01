package com.LambdaExpressions;
interface IFuncInt {
    int func(int num1, int num2) throws Exception;
}
public class LambdaExceptionDemo {
    public static void main(String[] args){
        IFuncInt funcInt = (int num1,int num2) -> {
            if(num1%num2==0)
            {
                return num1%num2;
            }
            else {
                throw new Exception();
            }
        };
        try {
            System.out.println("" + funcInt.func(7, 7));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
