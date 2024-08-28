package com.PractisePrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class programArrayList {
    public static void main(String[] args) {
        String str1 = "java";
        //String str2 = java;
        String str3 = new String("java");

        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));
        System.out.println(str3==str1);

        int arrSize = 5;
        ArrayList<Integer> arrNum1 = new ArrayList<>(5);
        System.out.println("Enter Array Elements  = ");
        Scanner scn = new Scanner(System.in);
        for (int i = 0 ; i < arrSize ; i++)
        {
            int num = scn.nextInt();
            arrNum1.add(num);
        }
        System.out.println(arrNum1);
    }
}
