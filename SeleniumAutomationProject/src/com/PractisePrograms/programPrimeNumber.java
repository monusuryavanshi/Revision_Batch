package com.PractisePrograms;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCnf;

import java.util.Scanner;

public class programPrimeNumber {
    public static void main(String[] args) {
        programPrimeNumber p = new programPrimeNumber();

        System.out.println("Enter Number = ");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        p.checkIsPrime(num);
    }

    public void checkIsPrime(int pNum)
    {
        int div = 0, temp = 0 ;
        boolean isPrime = true;
        div = pNum/2;
        if (pNum==0||pNum==1)
        {
            System.out.println("Number is not prime");
        }
        else
        {
            for (int i = 2; i <= div; i ++)
            {
                temp = pNum%i;
                if (temp==0)
                {
                    isPrime = false;
                    System.out.println(pNum + " Number is Not Prime");
                    break;
                }
            }
        }
        if (isPrime)
        {
            System.out.println(pNum + " Number is Prime");
        }
    }
}
