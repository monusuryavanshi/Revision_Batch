package com.PractisePrograms;

import java.util.Scanner;

public class programFibonacciSeries {
    public static void main(String[] args) {
        programFibonacciSeries p = new programFibonacciSeries();
        int fSeq = 0 ;
        System.out.println("Enter value of Fibonacci Series : ");
        Scanner scn = new Scanner(System.in);
        fSeq = scn.nextInt();
        p.getFibonacciSeries(fSeq);
    }

    public void getFibonacciSeries(int num)
    {
        int a = 0, b = 1 , c = 0;
        for (int i = 0; i < num ; i ++)
        {
            System.out.println(a + "");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("");
    }
}
