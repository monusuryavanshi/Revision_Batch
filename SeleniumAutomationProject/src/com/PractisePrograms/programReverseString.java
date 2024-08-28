package com.PractisePrograms;

import java.util.Scanner;

public class programReverseString {
    public static void main(String[] args) {
        String str ="";
        System.out.println("Enter String to Reverse :");
        Scanner scn = new Scanner(System.in);
        str = scn.next();
        programReverseString p = new programReverseString();
        p.getReverString(str);
    }

    public void getReverString(String str)
    {
        int len = str.length();
        String revStr = "";
        char[] arrChars = str.toCharArray();
        for (int i = len - 1; i >= 0 ; i--)
        {
            revStr = revStr + str.charAt(i);
        }
        System.out.println("Original String is as : "+ str + ", & Reversed String is : " + revStr);
    }
}
