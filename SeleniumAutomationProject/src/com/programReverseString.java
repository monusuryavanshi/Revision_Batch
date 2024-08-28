package com;

import java.util.Arrays;
import java.util.Scanner;

public class programReverseString {
    public static void main(String[] args) {
        String s = "";
        System.out.println("enter the string :");
        Scanner scn = new Scanner(System.in);
        s = scn.next();
        int l = s.length();
        System.out.println(l);
        String reS = "";
        for (int i = l - 1; i >= 0 ; i--)
        {
            reS = reS + s.charAt(i);
        }
        System.out.println(reS);
    }
}
